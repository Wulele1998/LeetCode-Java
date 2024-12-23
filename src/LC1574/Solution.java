package LC1574;

/**
 * LC 1574. Shortest Subarray to be Removed to Make Array Sorted
 */
public class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        // two pointer
        // N: the length of `arr`
        // time: O(N)
        // space: O(1)
        int right = arr.length-1;
        while (right > 0 && arr[right] >= arr[right - 1]){
            right--;
        }

        // arr[0, right) is unsorted
        int left = 0;
        int res = right;

        while (left < right && (left == 0 || arr[left] >= arr[left - 1])) {
            // for each valid left index, find its right index
            while (right < arr.length && arr[right] < arr[left]) {
                right++;
            }
            res = Math.min(res, right - left - 1);
            left++;
        }

        return res;
    }
}
