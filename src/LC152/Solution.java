package LC152;

public class Solution {
    public int maxProduct(int[] nums) {
        // Dynamic Programming
        // N: the length of nums
        // time: O(N)
        // space: O(1)
        int n = nums.length;
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int res = nums[0];

        for (int i = 1; i < n; i++) {
            int maxVal = Math.max(nums[i], Math.max(maxProduct * nums[i], minProduct * nums[i]));
            minProduct = Math.min(nums[i], Math.min(maxProduct * nums[i], minProduct * nums[i]));
            maxProduct = maxVal;
            res = Math.max(res, maxProduct);
        }

        return res;
    }
}
