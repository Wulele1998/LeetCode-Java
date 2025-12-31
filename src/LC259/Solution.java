package LC259;

import java.util.Arrays;

/**
 * Nov 19, 2025
 * LC 259. 3Sum Smaller
 */
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        // N: the length of `nums`
        // time: O(N * logN + N ^ 2) = O(N ^ 2)
        // space: O(log N), the space using in sort
        int res = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            res += twoSumSmaller(nums, target - nums[i], i);
        }

        return res;
    }

    /**
     * get the number of two-number pairs whose sum is smaller than `target`
     * @param nums `nums`
     * @param target target number
     * @param i the left border index , range from (`i`, `nums.length - 1`]
     * @return the number of two-number pairs whose sum is smaller than `target`
     */
    private int twoSumSmaller(int[] nums, int target, int i) {
        // N: the length of nums
        // time: O(N)
        // space: O(1)
        int j = i + 1;
        int k = nums.length - 1;
        int res = 0;

        while (j < k) {
            if (nums[j] + nums[k] < target) {
                // `nums[j]` + all numbers between `nums[j + 1, k]` are qualified
                res += k - j;
                j++; // move `j` to the right, make the pair sum larger
            } else {
                // `nums[j] + nums[k] >= target`, move `k` to the left, make the pair sum smaller
                k--;
            }
        }

        return res;
    }
}
