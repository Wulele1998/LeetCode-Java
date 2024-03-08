package LC221;

/**
 * LC 221. Maximal Square
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        // DP
        // M: the number of rows
        // N: the number of columns
        // time: O(M * N)
        // space: O(M * N)
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                res = Math.max(res, dp[0][i]);
            }
               
        }

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                res = Math.max(dp[i][0], res);
            }
                
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        return res * res;
    }
}
