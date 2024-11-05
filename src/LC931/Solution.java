package LC931;

/**
 * LC 931. Minimum Falling Path Sum
 */
public class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // DP: top-down
        // N: the `matrix` is N * N
        // time: O(N * N)
        // space: O(N * N)
        int n = matrix.length;
        int[][] dp = new int[n][n];
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0;j < n; j++) {
                int dis1 = j - 1 >= 0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                int dis2 = dp[i - 1][j];
                int dis3 = j + 1 < n ? dp[i - 1][j + 1] : Integer.MAX_VALUE;

                dp[i][j] = Math.min(dis1, Math.min(dis2, dis3)) + matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }

        return res;
    }
}
