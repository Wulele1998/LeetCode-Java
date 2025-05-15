package LC2560;

import java.util.Arrays;

/**
 * LC 2560. House Robber IV
 */
public class Solution {
    public int minCapability(int[] nums, int k) {
        // binary search
        int maxVal = Arrays.stream(nums).max().getAsInt();
        int minVal = Arrays.stream(nums).min().getAsInt();

        while (minVal < maxVal) {
            int midVal = (maxVal + minVal) / 2;
            int theftCount = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= midVal) {
                    theftCount++;
                    i++;
                }
            }

            if (theftCount >= k) {
                maxVal = midVal;
            } else {
                minVal = midVal + 1;
            }
        }

        return minVal;
    }
}
