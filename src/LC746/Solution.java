package LC746;

public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // Dynamic Programming
        // N: the length of `cost`
        // time: O(N)
        // space: O(N)
        int n = cost.length;
        int[] dp = new int[n + 1];

        // either start from index 0 or index 1
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }

        return dp[n];
    }
}
