package LC1230;

public class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        // DP
        // N: the length of `prob`
        // M: `target`
        // time: O(M * N)
        // space: O(M * N)
        int n = prob.length;
        double[][] dp = new double[n + 1][target + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] * (1 - prob[i - 1]);
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j - 1] * prob[i] + dp[i - 1][j] * (1 - prob[i]);
            }
        }

        return dp[n][target];
    }
}
