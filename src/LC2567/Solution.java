package LC2567;

import java.util.Arrays;

public class Solution {
    public int minimizeSum(int[] nums) {
        // the low |x| is 0
        // we only need to get the minimal value of high |x|
        // N: the length of `nums`
        // time: O(N log N) => Java Quick Sort
        // space: O(log N) => Java Quick Sort
        Arrays.sort(nums);
        int n = nums.length;
        int diff1 = nums[n - 1] - nums[2];
        int diff2 = nums[n - 3] - nums[0];
        int diff3 = nums[n - 2] - nums[1];

        return Math.min(diff1, Math.min(diff2, diff3));
    }
}
