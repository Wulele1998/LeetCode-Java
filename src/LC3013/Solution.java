package LC3013;

import java.util.Arrays;

/**
 * Feb 2, 2026
 * LC 3013. Divide an Array Into Subarrays With Minimum Cost II
 */
public class Solution {
    // N: the length of `nums`
    // K: number `k`
    // D: number `dist`
    // time: O(N * (D * logD + K))
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        long res = Long.MAX_VALUE;
       
        // [n - k + 1, n - 1] => k - 1 element
        for (int i = 1; i <= n - k + 1; i++) {
            // all the left k - 1 indices will be within the window [i, min(n-1, i+dist)]
            int windowStart = i;
            int windowEnd = Math.min(n - 1, i + dist);
            int[] array = new int[windowEnd - windowStart + 1];
            System.arraycopy(nums, windowStart, array, 0, windowEnd - windowStart + 1);
            Arrays.sort(array);
            long totalCost = 0L;
            for (int j = 0; j < k - 1; j++) {
                totalCost += array[j];
            }

            res = Math.min(res, totalCost);
            
        }

        return res + nums[0];
    }
}
