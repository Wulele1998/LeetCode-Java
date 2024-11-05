package LC977;

/**
 * LC 977. Squares of a Sorted Array
 */
public class Solution2 {
    public int[] sortedSquares(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(1)
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[nums.length];

        int i = nums.length - 1;
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if (leftSquare > rightSquare) {
                res[i--] = leftSquare;
                left++;
            } else {
                res[i--] = rightSquare;
                right--;
            }
        }

        return res;
    }
}
