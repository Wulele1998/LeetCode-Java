package LC213;

public class Solution {
    public int rob(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(1)
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        return Math.max(helper(nums, 0, n - 2), helper(nums, 1, n - 1));
    }

    private int helper(int[] nums, int start, int end) {
        // Dynamic Programming optimized space O(1)
        // N: the length of `nums`
        // time: O(N)
        // space: O(1)
        // the robber works between [start, end]
        int first = 0;
        int second = 0;

        for (int i = start; i <= end; i++) {
            int next = Math.max(first + nums[i], second);
            first = second;
            second = next;
        }

        return second;
    }
}
