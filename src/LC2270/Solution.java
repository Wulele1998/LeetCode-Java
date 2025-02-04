package LC2270;

/**
 * LC 2270. Number of Ways to Split Array
 */
public class Solution {
    public int waysToSplitArray(int[] nums) {
        // prefix sum
        // N: the length of nums
        // time: O(N)
        // space: O(1)
        int n = nums.length;
        long sum = 0L;
        int res = 0;

        for (int num : nums) {
            sum += num;
        }
        long leftSum = 0;

        for (int i = 0; i < n - 1; i++) {
            leftSum += nums[i];
            if (leftSum >= sum - leftSum) {
                res++;
            }
        }

        return res;
    }
}
