package LC1464;

import java.util.Arrays;

public class Solution {
    public int maxProduct(int[] nums) {
        // N: the length of `nums`
        // time: O(N * log N)
        // space: O(log N), Java uses quick sort which needs O(log N) space
        Arrays.sort(nums);
        int n = nums.length;

        return (nums[n - 1] - 1) * (nums[n - 2] - 1);
    }
}
