package LC3010;

/**
 * Feb 1, 2026
 * LC 3010. Divide an Array Into Subarrays With Minimum Cost I
 */
public class Solution {
    public int minimumCost(int[] nums) {
        // time: O(N)
        // space: O(1)
        int min1 = nums[0];
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num < min2) {
                min3 = min2;
                min2 = num;
            } else if (num < min3) {
                min3 = num;
            }
        }

        return min1 + min2 + min3;
    }
}
