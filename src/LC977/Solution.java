package LC977;

/**
 * LC 977. Squares of a Sorted Array
 */
public class Solution {
    public int[] sortedSquares(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(1)
        int border = 0;
        int n = nums.length;
        int[] res = new int[n];

        while (border < n && nums[border] < 0) {
            border++;
        }

        int neg = border - 1;
        int pos = border;
        int i = 0;
        while (neg >= 0 || pos < n) {
            int left = neg >= 0 ? nums[neg] * nums[neg] : Integer.MAX_VALUE;
            int right = pos < n ? nums[pos] * nums[pos] : Integer.MAX_VALUE;
            if (left < right) {
                res[i] = left;
                neg--;
            } else {
                res[i] = right;
                pos++;
            }
            i++;
        }

        return res;
    }
}
