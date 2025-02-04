package LC2444;

/**
 * LC 2444. Count Subarrays With Fixed Bounds
 */
public class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        // two pointers
        // N: the length of `nums`
        // time: O(N)
        // space: O(1)
        long res = 0L;
        int leftBound = -1;
        int minKIndex = -1;
        int maxKIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxK || nums[i] < minK) {
                leftBound = i;
            }
            if (nums[i] == minK) {
                minKIndex = i;
            }
            if (nums[i] == maxK) {
                maxKIndex = i;
            }
            res += Math.max(0, Math.min(maxKIndex, minKIndex) - leftBound);
        }

        return res;
    }
}
