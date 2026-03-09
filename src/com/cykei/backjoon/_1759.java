package com.cykei.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class _1759 {
    // L 개 알파벳 소문자. <= a,e,i,o,u 중 한개, 최소 2개의 자음
    // 암호는 항상 정렬되있음.
    // C 개의 문자가 주어진다. 가능성 있는 암호를 모두 구해라.
    // 즉, C 개의 문자 chars 중에 a,e,i,o,u 중 최소 1개 이상, 최소 2개는 자음.


    static char[] chars;
    static int L;
    static char[] temp;
    static HashSet<Character> moemSet;

    public static void go(int cnt, int start) {
        if (cnt == L) {
            StringBuilder sb = new StringBuilder();
            int moemCnt = 0;
            int zaumCnt = 0;
            for (char c : temp) {
                if (moemSet.contains(c)) moemCnt++;
                else zaumCnt++;
                sb.append(c);
            }

            if (moemCnt >= 1 && zaumCnt >= 2) {
                System.out.println(sb);
            }
            return;
        }
        for (int i = start; i < chars.length; i++) {
            temp[cnt] = chars[i];
            go(cnt + 1, i + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        temp = new char[L];
        chars = new char[C];
        char[] moem = {'a', 'e', 'i', 'o', 'u'};
        moemSet = new HashSet<>();

        for (char m : moem) {
            moemSet.add(m);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(chars);

        go(0, 0);

    }
}
