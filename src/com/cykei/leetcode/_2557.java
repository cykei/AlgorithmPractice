package com.cykei.leetcode;

/*
문제: https://leetcode.com/problems/count-unguarded-cells-in-the-grid/description/?envType=daily-question&envId=2024-11-21
- 보호받지 못하는 셀의 개수를 구해라.
풀이
- 2 <= m * n <= 10만이라는 제약조건이 있다 => 브루트 포스 방식으로 풀 수 있다.
 */

public class _2557 {
    int[][] board;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int N;
    int M;

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        N = m;
        M = n;
        board = new int[N][M];
        for (int[] guard : guards) {
            int x = guard[0];
            int y = guard[1];
            board[x][y] = 1; // guard = 1
        }
        for (int[] wall : walls) {
            int x = wall[0];
            int y = wall[1];
            board[x][y] = 2; // walls = 2
        }

        // search
        for (int[] guard : guards) {
            int x = guard[0];
            int y = guard[1];
            dfs(x, y);
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                //System.out.print(board[i][j]+" ");
                if (board[i][j] == 0) answer++;
            }
            //System.out.println("\n");
        }
        return answer;
    }

    private void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            go(i, x, y);
        }
    }

    private void go(int dir, int cx, int cy) {
        int nx = cx + dx[dir];
        int ny = cy + dy[dir];
        if (nx < 0 || ny < 0 || nx >= N || ny >= M) return;
        if (board[nx][ny] == 1 || board[nx][ny] == 2) return;
        board[nx][ny] = 3;
        go(dir, nx, ny);
    }

    public static void main(String[] args) {
        _2557 q = new _2557();
        int answer = q.countUnguarded(4, 6, new int[][]{{0, 0}, {1, 1}, {2, 3}}, new int[][]{{0, 1}, {2, 2}, {1, 4}});
        System.out.println(answer);
    }
}
