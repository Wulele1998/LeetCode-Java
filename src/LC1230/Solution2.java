package LC1230;

/**
 * LC 1230. Toss Strange Coins
 */
public class Solution2 {
    public double probabilityOfHeads(double[] prob, int target) {
        // Dynamic Programming, bottom-up, space optimization
        // N: the length of `prob`
        // M: `target`
        // time: O(N * M)
        // space: O(N)
        int n = prob.length; // the number of coins
        // DP problem
        // dp[i][j]: j coin heads up using the first i coins
        // transition:
        // dp[i][j] = dp[i - 1][j - 1] * prob[i - 1] + dp[i - 1][j] * (1 - prob[i - 1])
        double[] dp = new double[target + 1];

        // base case:
        dp[0] = 1; // no coin, no facing heads
        for (int i = 1; i <= n; i++) {
            // j = 0
            for (int j = Math.min(i, target); j >= 1; j--) {
                // the dp[i] needs dp[i - 1], we need to make sure the dp[i - 1] is not overwritten
                // traverse j from i to 1
                dp[j] = dp[j - 1] * prob[i - 1] + dp[j] * (1 - prob[i - 1]);
            }
            dp[0] = dp[0] * (1 - prob[i - 1]);
        }

        return dp[target];
    }
}
