package LC2962;

import java.util.Arrays;

/**
 * LC 2962. Count Subarrays Where Max Element Appears at Least K Times
 */
public class Solution {
    public long countSubarrays(int[] nums, int k) {
        // slide windows
        // N: the length of `nums`
        // time: O(N)
        // space: O(1)
        long res = 0L;
        int start = 0;
        int maxNum = Arrays.stream(nums).max().orElse(Integer.MIN_VALUE);
        int count = 0;

        for (int num : nums) {
            if (num == maxNum) {
                count++;
            }
            while (count == k) {
                if (nums[start] == maxNum) {
                    count--;
                }
                start++;
            }
            res += start;
        }

        return res;
    }
}
