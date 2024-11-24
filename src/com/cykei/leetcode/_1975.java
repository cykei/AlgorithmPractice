package com.cykei.leetcode;

/*
문제 : Maximum Matrix Sum
https://leetcode.com/problems/maximum-matrix-sum/description/?envType=daily-question&envId=2024-11-24
n x n 행렬이 주어진다.
인접한 두수에 -1 을 곱할 수 있다.
전체 행렬의 덧셈값이 최대가 되게 -1을 곱한후, 최대 값을 반환하라.

풀이 : 수학적으로 생각해보면 되는 문제.
- 최대가 되는 경우 : 모든 값이 양수가 되는 경우다.
- 최대를 만들 수 있는 경우: 행렬에 음수값이 짝수개 있는 경우이다. 2개씩 바꿀 수 있으니까 짝수개 있으면 최종적으로는 모든 수를 양수로 변경할 수 있다.
- 최대를 만들 수 없는 경우: 행렬에 음수값이 홀수개 있는 경우. 이럴때는 행렬에 있는 가장 작은 수를 음수로 만드는게 모든 수를 더한값을 최대로 만드는 방법이다.
 */
public class _1975 {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long sum = 0;
        int negative = 0;

        // 1. 음수의 개수를 센다.
        int minimum = 100000;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = matrix[i][j];
                if (Math.abs(num) < minimum) {
                    minimum = Math.abs(num);
                }
                if (num < 0) {
                    negative++;
                    sum -= num;
                } else {
                    sum += num;
                }
            }
        }
        // 2. 음수개수가 짝수면 합산값을 반환한다.
        if (negative % 2 == 0) return sum;
        else {
            // 3. 음수개수가 음수면 가장 작은 값을 합산값에서 뺀다.
            return sum - minimum * 2L;
        }
    }
}
