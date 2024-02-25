package LC896;

public class Solution {
    public boolean isMonotonic(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(1)
        boolean isIncrease = true;
        boolean isDecrease = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i  - 1]) {
                isDecrease = false;
            }
            if (nums[i] < nums[i - 1]) {
                isIncrease = false;
            }
        }

        return isDecrease || isIncrease;
    }
}
