package LC494;

import java.util.Arrays;

/**
 * LC 494. Target Sum
 */
public class Solution2 {
    // DP top-down memoization
    // N: the length of `nums`
    // M: the sum of `nums`
    // time: O(N * M)
    // space: O(N * M)
    private int[][] memo;
    private int sum;

    public int findTargetSumWays(int[] nums, int target) {
        sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < target || -sum > target) {
            return 0;
        }
        memo = new int[nums.length + 1][sum * 2 + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return findWays(nums, target, 0, 0);
    }

    private int findWays(int[] nums, int target, int index, int current) {
        if (index == nums.length) {
            return current == target ? 1 : 0;
        }

        if (memo[index][sum + current] != -1)
            return memo[index][sum + current];

        memo[index][sum + current] = findWays(nums, target, index + 1, current + nums[index]) + findWays(nums, target, index + 1, current - nums[index]);
        return memo[index][sum + current];
    }
}
