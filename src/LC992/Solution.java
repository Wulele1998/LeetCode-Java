package LC992;

import java.util.HashMap;

/**
 * LC 992. Subarrays with K Different Integers
 */
public class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // slide windows
        // N: the length of `nums`
        // time: O(N)
        // space: O(N)
        return subarraysWithMostKDistinct(nums, k) - subarraysWithMostKDistinct(nums, k - 1);
    }

    private int subarraysWithMostKDistinct(int[] nums, int mostK) {
        int left = 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.size() <= mostK) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }

            res += right - left + 1;
        }

        return res;
    }
}
