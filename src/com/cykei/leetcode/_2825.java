package com.cykei.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
2024-12-11 3:33~3:57
문제 : 2825. Make String a Subsequence Using Cyclic Increments
https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/?envType=daily-question&envId=2024-12-04

str1 과 str2 가 있다.
str1 의 특정 인덱스를 선택해서 다음 알파벳으로 만들 수 있다.
예 ) a->b , z->a, c->d 로 변경가능
이렇게 변경해서 만든 str1의 부분수열이 str2가 될수 있으면 true를 반환하라.
각 자릿수에 대해 선택은 최대 한번 가능하다.

풀이:
str1 은 10만이하. 선택하냐 안하냐 -> 총 경우의 수 = 2의 10만승 -> 안됨.
str1 을 순회하면서 str2의 처음 글자부터 전부 만들 수 있으면 true. 못하면 false 를 반환.

 */
public class _2825 {
    public boolean canMakeSubsequence(String str1, String str2) {
        if (str1.length() < str2.length()) return false;
        boolean result = false;
        int cur = 0;
        for (int i = 0; i < str1.length(); i++) {
            char curStr1 = str1.charAt(i);
            if (cur < str2.length() && curStr1 == str2.charAt(cur)) {
                cur++;
            } else if (cur < str2.length() && nextChart(curStr1) == str2.charAt(cur)) {
                cur++;
            }
        }
        if (cur == str2.length()) return true;
        return result;
    }

    public char nextChart(char target) {
        if (target == 'z') return 'a';
        return (char) (target + 1);
    }

    public static void main(String[] args) {
        _2825 a = new _2825();
        List<Boolean> results = new ArrayList<>();
        results.add(a.canMakeSubsequence("abcdef", "adg")); // true
        results.add(a.canMakeSubsequence("abcdef", "agh")); // false
        results.add(a.canMakeSubsequence("dm", "e"));
        System.out.println(results);
    }
}
