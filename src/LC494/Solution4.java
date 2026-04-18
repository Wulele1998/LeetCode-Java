package LC494;

import java.util.Arrays;

public class Solution4 {
    public int findTargetSumWays(int[] nums, int target) {
        // DP bottom-up space optimized
        // N: the length of `nums`
        // M: the sum of `nums`
        // time: O(M)
        // space: O(M)
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // edge case
        if (target > sum || target < -sum) {
            return 0;
        }

        int[] dp = new int[sum * 2 + 1];
        int[] dpNext = new int[sum * 2 + 1];
        // base case: when `target == 0`, 1 way which is empty
        dp[sum] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < sum * 2 + 1; j++) {
                if (dp[j] > 0) {
                    dpNext[j - nums[i]] += dp[j];
                    dpNext[j + nums[i]] += dp[j];
                }
            }

            int[] tmp = dp;
            dp = dpNext;
            dpNext = tmp;
            Arrays.fill(dpNext, 0);
        }

        return dp[sum + target];
    }
}
