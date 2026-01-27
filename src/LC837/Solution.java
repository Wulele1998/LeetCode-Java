package LC837;

/**
 * LC 837. New 21 Game
 */
public class Solution {
    public double new21Game(int n, int k, int maxPts) {
        // edge case
        if (k == 0 || n >= k - 1 + maxPts) {
            return 1.0;
        }
        // dp[i] => the possibility that Alice has points == i
        // base case: dp[0] = 1.0
        // transition:
        // card: [1, pts], dp[i] = (dp[i - 1] + dp[i - 2] + ... + dp[i - pts]) / pts
        double[] dp = new double[n + 1];
        dp[0] = 1.0; // start from 0
        double probSum = 1.0;
        double res = 0.0;
        for (int i = 1; i <= n; i++) {
            dp[i] = probSum / maxPts;
            if (i < k) {
                // Alice can draw more cards
                probSum += dp[i];
            } else {
                // i >= k, Alice cannot draw cards
                res += dp[i];
            }
            if (i >= maxPts) {
                probSum -= dp[i -maxPts];
            }
        }

        return res;
    }


}
