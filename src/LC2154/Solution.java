package LC2154;

import java.util.HashSet;

/**
 * Nov 19, 2025
 * LC 2154. Keep Multiplying Found Values by Two
 */
public class Solution {
    public int findFinalValue(int[] nums, int original) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(N)
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num % original == 0) {
                set.add(num);
            }
        }

        while (set.contains(original)) {
            original *= 2;
        }

        return original;
    }
}
