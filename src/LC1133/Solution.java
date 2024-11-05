package LC1133;

import java.util.HashMap;


/**
 * LC 1133. Largest Unique Number
 */
public class Solution {
    public int largestUniqueNumber(int[] nums) {
        // N: the number of elements in `nums`
        // time: O(N)
        // space: O(N)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int res = -1;
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                res = Math.max(res, key);
            }
        }

        return res;
    }
}
