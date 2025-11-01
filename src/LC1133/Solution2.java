package LC1133;

import java.util.TreeMap;

/**
 * LC 1133. Largest Unique Number
 */
public class Solution2 {
    public int largestUniqueNumber(int[] nums) {
        // time: O(N  * logN)
        // space: O(N)
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.descendingKeySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }

        return -1;
    }
}
