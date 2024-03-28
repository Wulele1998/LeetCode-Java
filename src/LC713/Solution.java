package LC713;

/**
 * LC 713. Subarray Product Less Than K
 */
public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // slide windows
        // N: the length of `nums`
        // time: O(N)
        // space: O(1)
        // [start, end]
        int start = 0;
        int product = 1;
        int count = 0;

        if (k <= 1) {
            return 0;
        }

        for (int end = 0; end < nums.length; end++) {
            product *= nums[end];
            while (product >= k && start <= end) {
                product /= nums[start];
                start++;
            }
            count += end - start + 1;
        }

        return count;
    }
}
