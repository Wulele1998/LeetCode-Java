package LC350;

import java.util.Arrays;

/**
 * LC 350. Intersection of Two Arrays II
 */
public class Solution2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        // M: the size of `nums1`
        // N: the size of `nums2`
        // time: O(M * logM + N * logN)
        // space: O(logM + logN)

        // two pointers
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                nums1[k++] = nums1[i];
                i++;
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
