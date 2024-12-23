package LC2563;

import java.util.Arrays;

public class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        // binary search
        // N: the length of `nums`
        // time: O(N * logN)
        // space: O(logN), sort the `nums`
        long res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int indexLower = binarySearch(nums, lower - nums[i], i + 1, nums.length - 1);
            int indexUpper = binarySearch(nums, upper - nums[i] + 1, i + 1, nums.length - 1);

            res += indexUpper - indexLower;
        }

        return res;
    }

    private int binarySearch(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
