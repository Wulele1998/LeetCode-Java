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

        // corner case
        if (n <= 4) {
            return 0;
        }

        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            res = Math.min(res, nums[n - 4 + i] - nums[i]);
        }

        return res;
    }
}
