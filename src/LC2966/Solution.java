package LC2966;

import java.util.Arrays;

/**
 * LC 2966. Divide Array Into Arrays With Max Difference
 */
public class Solution {
    public int[][] divideArray(int[] nums, int k) {
        // N: the length of `nums`
        // time: O(N * logN)
        // space: O(log N)
        Arrays.sort(nums);

        int[][] res = new int[nums.length / 3][3];

        for (int i = 0; i < nums.length; i += 3) {
            if (nums[i + 2] - nums[i] <= k) {
                res[i / 3][0] = nums[i];
                res[i / 3][1] = nums[i + 1];
                res[i / 3][2] = nums[i + 2];
            } else {
                return new int[][] {};
            }
        }

        return res;
    }
}
