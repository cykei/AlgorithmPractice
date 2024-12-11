package com.cykei.leetcode;

import java.util.*;

/*
773. Sliding Puzzle
문제: https://leetcode.com/problems/sliding-puzzle/description/?envType=daily-question&envId=2024-11-25
풀이: BFS
- 아이디어를 생각해내는 것이 매우 어려운 HARD 난이도 문제
- 답지를 참고했다.
- 1. 각 위치에서 움직일수 있는 곳은 정해져있다. 그걸 일단 전부 저장한다.
- 2. 매 턴마다 0의 위치에서 움직일 수 있는 곳을 전부 간다. (BFS)
- 3. 방문했을 시의 상태를 1차원 배열 + 문자열로 만들어 저장한다.
- 4. 문자열이 123450 이 되면 종료한다. 2번에서 이미 만들어졌던 문자열이라면 가지 않는다.
 */

public class _773 {

    public int slidingPuzzle(int[][] board) {

        Queue<List<int[]>> q = new LinkedList<>();
        List<int[]> initData = new ArrayList<>();  // 0위치, 현재 상태
        int[] start = new int[2];
        int[] sboard = new int[6];
        int c = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sboard[c] = board[i][j];
                if (sboard[c] == 0) {
                    start[0] = c;
                    sboard[c] = -1;
                }
                c++;
            }
        }
        initData.add(start);
        initData.add(sboard);
        q.add(initData);

        int[][] move = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        Set<String> visited = new HashSet<>();
        while (!q.isEmpty()) {
            List<int[]> curData = q.poll();
            int cur = curData.get(0)[0];
            int cnt = curData.get(0)[1];
            int[] status = curData.get(1);
            if (makeStatusString(status).equals("12345-1")) {
                return cnt;
            }
            for (int i = 0; i < move[cur].length; i++) {
                int next = move[cur][i];
                int[] nextStatus = makeNextStatus(status, next, cur);
                String statusStr = makeStatusString(nextStatus);
                if (!visited.contains(statusStr)) {
                    visited.add(statusStr);
                    List<int[]> nextData = new ArrayList<>();
                    nextData.add(new int[]{next, cnt + 1});
                    nextData.add(nextStatus);
                    q.add(nextData);
                }
            }
        }
        return -1;
    }


    private int[] makeNextStatus(int[] status, int next, int cur) {
        int[] nboard = new int[6];
        nboard[next] = -1;
        nboard[cur] = status[next];

        for (int i = 0; i < 6; i++) {
            if (nboard[i] == 0) {
                nboard[i] = status[i];
            }
        }

        return nboard;
    }

    private String makeStatusString(int[] status) {
        StringBuilder s = new StringBuilder();
        for (int j : status) {
            s.append(j);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        _773 a = new _773();
        List<Integer> results = new ArrayList<>();
        results.add(a.slidingPuzzle(new int[][]{{1, 2, 3}, {5, 4, 0}})); // -1
        results.add(a.slidingPuzzle(new int[][]{{4, 1, 2}, {5, 0, 3}})); // 5
        System.out.println(results);
    }
}
