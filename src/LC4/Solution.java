package LC4;

class Solution {
    // O(log (M + N))
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // binary search without merge two arrays
        int m = nums1.length;
        int n = nums2.length;

        if (m + n == 0) {
            return 0.0;
        }

        if ((m + n) % 2 == 0) {
            int leftKth = (m + n) / 2;
            int rightKth = (m + n) / 2 + 1;
            return (getKthNum(nums1, nums2, 0, 0, leftKth) + getKthNum(nums1, nums2, 0, 0, rightKth)) / 2.0;
        } else {
            int medianKth = (m + n + 1) / 2;
            return getKthNum(nums1, nums2, 0, 0, medianKth);
        }
    }
    /**
     * get the k-th smallest number from two arrays
     * @param nums1 array 1
     * @param nums2 array 2
     * @param index1 the start index of array 1
     * @param index2 the start index of array 2
     * @param k the k-th
     * @return the k-th smallest number value
     */
    private int getKthNum(int[] nums1, int[] nums2, int index1, int index2, int k) {
        int validLen1 = nums1.length - index1;
        int validLen2 = nums2.length - index2;

        // base case
        if (validLen1 == 0) {
            // nums1 valid length is 0, get the k-th number from nums2 directly
            // valid range: nums2[index2:]
            return nums2[index2 + k - 1];
        }
        if (validLen2 == 0) {
            // nums2 valid length is 0, get the k-th number from nums1 directly
            // valid range: nums1[index1:]
            return nums1[index1 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[index1], nums2[index2]);
        }

        // split k-th average to k / 2 + k / 2, assign to both nums1, nums2
        int halfK1 = Math.min(k / 2, validLen1); // half k-th, which is 1-indexed
        int halfK2 = Math.min(k / 2, validLen2);
        int numHalfK1 = nums1[index1 + halfK1 - 1];
        int numHalfK2 = nums2[index2 + halfK2 - 1];

        if (numHalfK1 <= numHalfK2) {
            // we should remove the smaller part, which is nums1[index1 : index1 + halfK1]
            return getKthNum(nums1, nums2, index1 + halfK1, index2, k - halfK1);
        } else {
            // we should remove the smaller part, which is nums2[index2 : index2 + halfK2];
            return getKthNum(nums1, nums2, index1, index2 + halfK2, k - halfK2);
        }
    }
}


