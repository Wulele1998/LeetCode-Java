package LC918;

public class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int normalSumMax = nums[0];
        int sum = 0;

        // calculate the normal sum of subarray
        for (int num : nums) {
            sum = Math.max(sum + num, num);
            normalSumMax = Math.max(normalSumMax, sum);
        }

        // calculate the prefix and suffix sum without overlap
        int[] suffixSumMax = new int[n];
        int suffixSum = nums[n - 1];
        suffixSumMax[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixSum += nums[i];
            suffixSumMax[i] = Math.max(suffixSumMax[i + 1], suffixSum);
        }

        int prefixSum = 0;
        int specialSumMax = nums[0];
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            if (i + 1 < n) {
                specialSumMax = Math.max(specialSumMax, prefixSum + suffixSumMax[i + 1]);
            }
        }

        return Math.max(specialSumMax, normalSumMax);
    }
}
