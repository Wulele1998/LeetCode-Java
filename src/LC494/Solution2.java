package LC494;

import java.util.Arrays;

/**
 * LC 494. Target Sum
 */
public class Solution2 {
    int totalSum = 0;
    public int findTargetSumWays(int[] nums, int target) {
        // recursion with memorization
        // N: the length of `nums`
        // time: O(N * SUM(nums))
        // space: O(N * SUM(nums))
        for (int num : nums) {
            totalSum += num;
        }
        int n = nums.length;

        // [-totalSum, totalSum]
        int[][] memo = new int[n][totalSum * 2 + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }

        return recursion(nums, 0, 0, target, memo);
    }

    private int recursion(int[] nums, int index, int sum, int target, int[][] memo) {
        if (index == nums.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (memo[index][sum + totalSum] != Integer.MIN_VALUE) {
                // the value has been calculated before
                return memo[index][sum + totalSum];
            } else {
                // positive
                int pos = recursion(nums, index + 1, sum + nums[index], target, memo);
                int neg = recursion(nums, index + 1, sum - nums[index], target, memo);
                memo[index][sum + totalSum] = pos + neg;
            }

            return memo[index][sum + totalSum];
        }
    }
}
