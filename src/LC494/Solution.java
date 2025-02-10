package LC494;

/**
 * LC 494. Target Sum
 */
public class Solution {
    int res = 0;
    public int findTargetSumWays(int[] nums, int target) {
        // recursion (brute force)
        // N: the length of `nums`
        // time: O(2 ^ N)
        // space: O(N), the depth of recursion stack
        recursion(nums, 0, 0, target);

        return res;
    }

    private void recursion(int[] nums, int index, int sum, int target) {
        if (index == nums.length) {
            if (sum == target) {
                res++;
            }
        } else {
            recursion(nums, index + 1, sum + nums[index], target);
            recursion(nums, index + 1, sum - nums[index], target);
        }
    }
}
