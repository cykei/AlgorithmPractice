package com.cykei.leetcode;
/*
2024-11-22
오후 8:27~8:57
문제 : https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/?envType=daily-question&envId=2024-11-22
각열에 해당하는 값을 뒤집어서 모든 행의 값이 같아지는 경우가 최대일때 모든 행이 같은 건 몇개 있는가?
풀이 :
- 다 해보면 되지 않을까?
- 160ms, 59.19mb O(N*M^2) 로, 시간복잡도 최악이지만 통과는 했다.
 */
public class _1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int answer = 0;
        for (int i=0; i<n; i++) { // 행
            int[][] temp = matrix.clone();
            for (int j=0; j<m; j++){ // 열
                if (temp[i][j] == 0) {
                    for (int k = 0; k<n; k++) {// 행!
                        temp[k][j] = temp[k][j] == 1? 0 : 1;
                    }
                }
            }

            // check
            int tempAnswer = 0;
            for (int x=0; x<n; x++) {
                int sumTemp = 0;
                for (int y=0; y<m; y++ ) {
                    sumTemp += temp[x][y];
                }
                if (sumTemp == 0 || sumTemp == m) tempAnswer++;
            }

            if (answer < tempAnswer) answer = tempAnswer;
        }
        return answer;
    }

    public static void main(String[] args) {
        _1072 q = new _1072();
        int answer = q.maxEqualRowsAfterFlips(new int[][] {{0,0,1},{1,0,1},{1,1,0}}); // 2
        System.out.println(answer);
    }
}
