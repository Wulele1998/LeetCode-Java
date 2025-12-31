package LC1770;

import java.util.Arrays;

/**
 * LC 1770. Maximum Score from Performing Multiplication Operations
 */
public class Solution {
    int[][] memo; // cache to avoid redundant calculation
    int m;
    int n;
    public int maximumScore(int[] nums, int[] multipliers) {
        // Dynamic Programming, Top-down
        // N: the length of `nums`
        // M: the length of `multipliers`
        // time: O(M * M)
        // space: O(M * M)
        n = nums.length;
        m = multipliers.length;
        memo = new int[m][m];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE); // initialize using the MIN value
        }

        return DP(nums, multipliers, 0, n - 1);
    }

    private int DP(int[] nums, int[] multipliers, int start, int end) {
        int usedOp = start + (n - 1 - end);
        if (usedOp == m) {
            return 0; // used all operations
        }

        if (memo[start][usedOp] != Integer.MIN_VALUE) {
            return memo[start][usedOp];
        }

        int chooseStart = multipliers[usedOp] * nums[start] + DP(nums, multipliers, start + 1, end);
        int chooseEnd = multipliers[usedOp] * nums[end] + DP(nums, multipliers, start, end - 1);
        memo[start][usedOp] = Math.max(chooseStart, chooseEnd);

        return memo[start][usedOp];
    }
}
