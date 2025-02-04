package LC2958;

import java.util.HashMap;

/**
 * LC 2958. Length of Longest Subarray With at Most K Frequency
 */
public class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        // slide window
        // N: the length of `nums`
        // time: O(N)
        // space: O(N)
        int res = 0;
        int start = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int end = 0; end < nums.length; end++) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            while (map.get(nums[end]) > k) {
                start++;
                map.put(nums[start], map.get(nums[start]) - 1);
            }

            res = Math.max(res, end - start);
        }

        return res;
    }
}
