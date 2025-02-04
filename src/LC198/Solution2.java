package LC198;

public class Solution2 {
    public int rob(int[] nums) {
        // Dynamic Programming optimize the space
        // N: the length of `nums`
        // time: O(N)
        // space: O(1)

        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int next = Math.max(first + nums[i], second);
            first = second;
            second = next;
        }

        return second;
    }
}
