package LC55;

public class Solution2 {
    public boolean canJump(int[] nums) {
        // Dynamic Programming optimized space
        // N: the length of `nums`
        // time: O(N)
        // space: O(1)

        int n = nums.length;
        int maxDistance = 0;

        for (int i = 0; i < n; i++) {
            if (maxDistance >= i) {
                maxDistance = Math.max(maxDistance, i + nums[i]);
            }
        }

        return maxDistance >= n - 1;
    }
}
