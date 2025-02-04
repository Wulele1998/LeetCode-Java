package LC53;

public class Solution2 {
    public int maxSubArray(int[] nums) {
        // Dynamic Programming optimized space
        // N: the length of nums
        // time: O(N)
        // space: O(1)
        int n = nums.length;
        int preSum = nums[0];
        int res = nums[0];

        for (int i = 1; i < n; i++) {
            preSum = Math.max(preSum + nums[i], nums[i]);
            res = Math.max(res, preSum);
        }

        return res;
    }
}
