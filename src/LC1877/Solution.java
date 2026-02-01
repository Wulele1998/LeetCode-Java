package LC1877;

import java.util.Arrays;

/**
 * Jan 24, 2026
 * LC 1877. Minimize Maximum Pair Sum in Array
 */
public class Solution {
    public int minPairSum(int[] nums) {
        // N: the length of `nums`
        // time: O(N logN)
        // space: O(logN)
        Arrays.sort(nums);
        int minIndex = 0;
        int maxIndex = nums.length - 1;
        int maxPairSum = Integer.MIN_VALUE;

        while (minIndex < maxIndex) {
            maxPairSum = Math.max(nums[maxIndex--] + nums[minIndex++], maxPairSum);
        }

        return maxPairSum;
    }
}
