package com.cykei.leetcode;

import java.util.*;

/*
문제: https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/?envType=daily-question&envId=2024-11-21
- nums 배열과 k가 주어진다. nums 배열에서 연속된 k개의 수가 가장 커지는 부분수열을 찾아라.
- 단, 부분수열을 이루는 연속된 수에 중복이 있으면 안된다.

풀이: 슬라이딩 윈도우!
 */
public class _2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;

        int begin = 0;
        int end = 0;
        int answer = 0;
        int temp = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (end < n) {
            int cur = nums[end];
            int lastShowIdx = map.getOrDefault(cur, -1);
            while (begin <= lastShowIdx || end - begin + 1 > k) {
                temp -= nums[begin]; //subtract first!
                begin++;
            }
            temp += nums[end];
            if (end-begin + 1 == k && answer < temp) {
                answer = temp;
            }
            map.put(cur, end);
            end++;
        }
        return answer;
    }

    public static void main(String[] args) {
        _2461 q = new _2461();
        List<Long> answers = new ArrayList<>();
        answers.add(q.maximumSubarraySum(new int[]{3,2,3,1}, 3)); // 6 <- 이런거 때문에 마지막으로 중복이었던 인덱스 번호를 알아야 하는군. 중복이 나오면 그 이후부터 카운팅 하는 방식으로는 이 케이스에 대응할 수 없다.
        answers.add(q.maximumSubarraySum(new int[]{1, 2, 2}, 2)); // 3
        answers.add(q.maximumSubarraySum(new int[]{1,5,4,2,9,9,9}, 3)); // 15
        answers.add(q.maximumSubarraySum(new int[]{4,4,4}, 3)); // 0
        answers.add(q.maximumSubarraySum(new int[]{1,1,2}, 2)); // 3 <- 이거에 대응하려면 두번째방법처럼 할 수 밖에 없음. 두개의 순회를 합치는건 불가능.
        answers.add(q.maximumSubarraySum(new int[]{9, 18, 10, 13, 17, 9, 19, 2, 1, 18}, 5)); // 68

        System.out.println(answers);
    }
}
