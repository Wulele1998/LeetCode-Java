package LC494;

/**
 * LC 494. Target Sum
 */
public class Solution3 {

    public int findTargetSumWays(int[] nums, int target) {
        // DP
        // N: the length of `nums`
        // time: O(N * SUM(nums))
        // space: O(N * SUM(nums))
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int n = nums.length;

        // [-totalSum, totalSum]
        int[][] dp = new int[n][totalSum * 2 + 1];
        dp[0][nums[0] + totalSum] += 1; // 1 way to get nums[0] / -nums[0] at index 0, other value is 0
        dp[0][-nums[0] + totalSum] += 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < totalSum * 2 + 1; j++) {
                if (dp[i - 1][j] > 0) {
                   dp[i][j - nums[i]] += dp[i - 1][j];
                   dp[i][j + nums[i]] += dp[i - 1][j];
                }
            }
        }

        return dp[n - 1][target + totalSum];
    }
}
