package LC349;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * LC 349. Intersection of Two Arrays
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // M: the length of `nums1`
        // N: the length of `nums2`
        // time: O(M + N)
        // space: O(M + N)
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        set1.retainAll(set2);
        int[] res = new int[set1.size()];
        int i = 0;
        for (int num : set1) {
            res[i++] = num;
        }

        return res;
    }
}
