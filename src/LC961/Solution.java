package LC961;

import java.util.HashSet;

/**
 * Jan 2, 2026
 * LC 961. N-Repeated Element in Size 2N Array
 */
public class Solution {
    public int repeatedNTimes(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(N)
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }

        return -1;
    }
}
