package LC55;

public class Solution {
    public boolean canJump(int[] nums) {
        // Dynamic Programming
        // N: the length of `nums`
        // time: O(N)
        // space: O(N)
        int n = nums.length;
        int[] dp = new int[n];

        // base case
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            if (dp[i - 1] >= i) {
                // can arrive index i
                dp[i] = Math.max(dp[i - 1], i + nums[i]);
            }
        }

        return dp[n - 1] >= n - 1;
    }
}
