package LC2540;

public class Solution2 {
    public int getCommon(int[] nums1, int[] nums2) {
        // M: the length of `nums1`
        // N: the length of `nums2`
        // time: O(M + N)
        // space: O(1)
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            } else if (nums1[i] > nums2[j]) {
                j++; // move j to larger number to see if match is possible
            } else {
                i++; // move i to larger number to see if match is possible
            }
        }

        return -1;
    }
}
