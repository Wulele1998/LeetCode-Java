package LC976;

import java.util.Arrays;

public class Solution {
    public int largestPerimeter(int[] nums) {
        // N: the length of `nums`
        // time: O(N * log N), sort time
        // space: O(log N), Java uses quick sort which needs O(log N)
        Arrays.sort(nums);
        
        for (int i = nums.length - 3; i >= 0; i--) {
            if (nums[i] + nums[i + 1] > nums[i + 2]) {
                // can construct a triangle
                return nums[i] + nums[i + 1] + nums[i + 2];
            }
        }
        return 0;
    }
}
