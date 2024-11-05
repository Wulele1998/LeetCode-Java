package LC2540;

import java.util.*;

/**
 * LC 2540. Minimum Common Value
 */
public class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        // M: the length of `nums1`
        // M: the length of `nums2`
        // time: O(M + N)
        // space: O(M)
        Set<Integer> set = new HashSet<>();
        for (int num : nums1)
            set.add(num);
        int min = Integer.MAX_VALUE;
        for (int num : nums2) {
            if (set.contains(num)) {
                min = Math.min(min, num);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
