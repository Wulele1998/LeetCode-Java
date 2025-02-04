package LC3105;

/**
 * LC 3105. Longest Strictly Increasing or Strictly Decreasing Subarray
 */
public class Solution2 {
    public int longestMonotonicSubarray(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(1)
        int increaseLen = 1;
        int decreaseLen = 1;
        int maxLen = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                increaseLen++;
                decreaseLen = 1;
            } else if (nums[i + 1] < nums[i]) {
                decreaseLen++;
                increaseLen = 1;
            } else {
                increaseLen = 1;
                decreaseLen = 1;
            }

            maxLen = Math.max(maxLen, Math.max(increaseLen, decreaseLen));
        }

        return maxLen;
    }
}
