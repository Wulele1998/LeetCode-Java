package LC287;

import java.util.Arrays;

/**
 * LC 287. Find the Duplicate Number
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        // N: the length of `nums`
        // time: O(N logN)
        // space: O(logN)
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }

        return -1;
    }
}
