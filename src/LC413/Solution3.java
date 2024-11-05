package LC413;

public class Solution3 {
    int sum = 0;
    public int numberOfArithmeticSlices(int[] nums) {
        // recursion
        // N: the length of `nums`
        // time: O(N)
        // space: O(N) => recursive stack
        helper(nums, nums.length - 1);

        return sum;
    }

    private int helper(int[] nums, int end) {
        // recursion ends
        if (end < 2) {
            return 0;
        }

        int count = 0;
        // nums[end-2, end] qualifies
        if (nums[end] - nums[end - 1] == nums[end - 1] - nums[end - 2]) {
            count = 1 + helper(nums, end - 1);
            sum += count;
        } else {
            helper(nums, end - 1);
        }

        return count;
    }
}
