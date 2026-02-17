package LC799;

/**
 * LC 799. Champagne Tower
 */
public class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        // N: query_row
        // time: O(N ^ 2)
        // space: O(N ^ 2)
        double[][] dp = new double[query_row + 1][query_row + 1];
        dp[0][0] = poured;

        for (int i = 1; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][0] = Math.max(dp[i - 1][0] - 1, 0) / 2;
                } else if (j == i) {
                    dp[i][i] = Math.max(dp[i - 1][i - 1] - 1, 0) / 2;
                } else {
                    dp[i][j] = (Math.max(dp[i - 1][j - 1] - 1, 0) + Math.max(dp[i - 1][j] - 1, 0)) / 2;
                }
            }
        }

        return Math.min(dp[query_row][query_glass], 1.0);
    }
}
