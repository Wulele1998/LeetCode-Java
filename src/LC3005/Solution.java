package LC3005;

import java.util.*;

/**
 * LC 3005. Count Elements With Maximum Frequency
 */
public class Solution {
    public int maxFrequencyElements(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(N)
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxValue = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxValue = Math.max(maxValue, entry.getValue());
        }

        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValue) {
                sum += maxValue;
            }
        }

        return sum;
    }
}
