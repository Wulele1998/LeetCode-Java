package LC487;

/**
 * LC 487. Max Consecutive Ones II
 */
public class Solution2 {
    public int findMaxConsecutiveOnes(int[] nums) {
        // sliding window
        // N: the length of nums
        // time: O(N)
        // space: O(1)
        int res = 0;
        int n = nums.length;
        int left = 0;
        int right = 0;
        int numZeros = 0;

        while (right < n) {
            if (nums[right] == 0) {
                numZeros++;
            }

            if (numZeros == 2) {
                // move left to remove one 0 inside the window
                while (nums[left] != 0) {
                    left++;
                }
                numZeros--;
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }
}
