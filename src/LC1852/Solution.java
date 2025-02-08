package LC1852;

import java.util.HashMap;

/**
 * LC 1852. Distinct Numbers in Each Subarray
 */
public class Solution {
    public int[] distinctNumbers(int[] nums, int k) {
        // N: the length of nums
        // time: O(N)
        // space: O(N - K)
        int n = nums.length;
        int[] res = new int[n - k + 1];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        res[0] = map.size();

        for (int i = k; i < n; i++) {
            // move the window
            // remove the nums[i - k]
            if (map.get(nums[i - k]) == 1) {
                map.remove(nums[i - k]);
            } else {
                map.put(nums[i - k], map.get(nums[i - k]) - 1);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            res[i - k + 1] = map.size();
        }

        return res;
    }
}
