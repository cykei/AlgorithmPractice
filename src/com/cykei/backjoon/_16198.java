package com.cykei.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16198 {
    static int max = 0;
    static int[] arr;
    static int[] visited;
    static int n;

    public static void dfs(int cnt, int sum) {
        if (cnt == n - 2) {
            max = Math.max(max, sum);
            return;
        }
        for (int i = 1; i < n - 1; i++) {
            if (visited[i] == 1) continue;

            visited[i] = 1;
            int left = i - 1;
            int right = i + 1;
            while (visited[left] == 1) left--;
            while (visited[right] == 1) right++;

            dfs(cnt + 1, sum + arr[left] * arr[right]);
            visited[i] = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        // N개의 에너지 구슬
        // i 번째 에너지 구슬의 무게는 W
        // 백트래킹을 이용해 모든 경우의 수를 다 구한다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        System.out.println(max);
    }
}
