package LC1014;

public class Solution2 {
    public int maxScoreSightseeingPair(int[] values) {
        // Dynamic Programming
        // N: the length of `values`
        // time: O(N)
        // space: O(N)
        int n = values.length;
        int[] dp = new int[n];
        dp[0] = values[0];
        int maxScore = 0;

        for (int i = 1; i < n; i++) {
            maxScore = Math.max(maxScore, dp[i - 1] + values[i] - i);
            dp[i] = Math.max(dp[i - 1], values[i] + i);
        }

        return maxScore;
    }
}
