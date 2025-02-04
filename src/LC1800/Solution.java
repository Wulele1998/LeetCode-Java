package LC1800;

/**
 * LC 1800. Maximum Ascending Subarray Sum
 */
public class Solution {
    public int maxAscendingSum(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(1)
        int res = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }

            res = Math.max(sum, res);
        }

        return res;
    }
}
