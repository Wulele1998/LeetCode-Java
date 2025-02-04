package LC53;

public class Solution {
    public int maxSubArray(int[] nums) {
        // Dynamic Programming
        // N: the length of nums
        // time: O(N)
        // space: O(N)
        int n = nums.length;
        int res = nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
