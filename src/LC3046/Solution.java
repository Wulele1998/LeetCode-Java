package LC3046;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 3046. Split the Array
 */
public class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(N)
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0; // count the element only appear once
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 2) {
                return false;
            }
            if (entry.getValue() == 1) {
                count++;
            }
        }

        return (count & 1) == 0;
    }
}
