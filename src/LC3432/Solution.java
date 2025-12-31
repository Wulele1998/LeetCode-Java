package LC3432;

/**
 * Dec 5, 2025
 * LC 3432. Count Partitions with Even Sum Difference
 */
public class Solution {
    public int countPartitions(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(1)
        int sum = 0;
        int res = 0;
        for (int num : nums) {
            sum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            sum -= nums[i];
            if (Math.abs(leftSum - sum) % 2 == 0) {
                res++;
            }
        }

        return res;
    }
}
