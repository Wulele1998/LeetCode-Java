package LC1509;

import java.util.Arrays;

/**
 * LC 1509. Minimum Difference Between Largest and Smallest Value in Three Moves
 */
public class Solution {
    public int minDifference(int[] nums) {
        // N: the length of `nums`
        // time: O(N * logN)
        // space: O(logN)
        int n = nums.length;
        if (n <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            minDiff = Math.min(minDiff, nums[i + n - 4] - nums[i]);
        }

        return minDiff;
    }
}
