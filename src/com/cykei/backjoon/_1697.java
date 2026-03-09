package com.cykei.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1697 {

    public static void main(String[] args) throws Exception {
        // 수빈: N. 동생: K
        // 수빈: x-1, x+1, 2*x

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int RIGHT = 100000;
        int LEFT = 0;
        // bfs 시작
        int[] visited = new int[100001];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n, 0});
        visited[n] = 1;

        int answer = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curPos = cur[0];
            int curTime = cur[1];
            if (curPos == k) {
                answer = Math.min(curTime, answer);
            }

            if (curPos + 1 <= RIGHT && visited[curPos + 1] != 1) {
                q.add(new int[]{curPos + 1, curTime + 1});
                visited[curPos + 1] = 1;
            }
            if (curPos - 1 >= LEFT && visited[curPos - 1] != 1) {
                q.add(new int[]{curPos - 1, curTime + 1});
                visited[curPos - 1] = 1;
            }
            if (curPos * 2 <= RIGHT && visited[curPos * 2] != 1) {
                q.add(new int[]{curPos * 2, curTime + 1});
                visited[curPos * 2] = 1;
            }
        }
        System.out.println(answer);
    }
}
