package LC3354;

/**
 * Oct 28, 2025
 * LC 3354. Make Array Elements Equal to Zero
 */
public class Solution {
    public int countValidSelections(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(N)
        int n = nums.length;
        int res = 0;
        int[] leftPrefixSum = new int[n];
        int[] rightPrefixSum = new int[n];

        leftPrefixSum[0] = 0;
        rightPrefixSum[n - 1] = 0;

        for (int i = 1; i < n; i++) {
            leftPrefixSum[i] = leftPrefixSum[i - 1] + nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            rightPrefixSum[i] = rightPrefixSum[i + 1] + nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (leftPrefixSum[i] == rightPrefixSum[i]) {
                    // both direction works
                    res += 2;
                } else if (Math.abs(leftPrefixSum[i] - rightPrefixSum[i]) == 1) {
                    // only one direction works
                    res++;
                }
            }
        }

        return res;
    }
}
