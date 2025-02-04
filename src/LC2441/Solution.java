package LC2441;

import java.util.HashSet;

/**
 * LC 2441. Largest Positive Integer That Exists With Its Negative
 */
public class Solution {
    public int findMaxK(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(N)
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(-num)) {
                res = Math.max(Math.max(num, -num), res);
            }
            set.add(num);
        }

        return res == 0 ? -1 : res;
    }
}
