package LC2570;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 2570. Merge Two 2D Arrays by Summing Values
 */
public class Solution {
    // time: O(MAX(M, N))
    // space: O(1)
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        List<int[]> merged = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < m || j < n) {
            int index1 = i < m ? nums1[i][0] : Integer.MAX_VALUE;
            int index2 = j < n ? nums2[j][0] : Integer.MAX_VALUE;
            if (index1 < index2) {
                merged.add(nums1[i]);
                i++;
            } else if (index1 > index2) {
                merged.add(nums2[j]);
                j++;
            } else {
                merged.add(new int[] {index1, nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
