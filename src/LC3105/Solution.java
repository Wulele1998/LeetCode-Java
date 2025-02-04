package LC3105;

/**
 * LC 3105. Longest Strictly Increasing or Strictly Decreasing Subarray
 */
public class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(1)
        int increase = 1;
        int decrease = 1;
        int res = 1;
        int flag = 0;
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                if (increase == 1 || flag == 1) {
                    // first increasing number or increasing sub-array
                    flag = 1;
                    increase++;
                    decrease = 1;
                }
                if (flag != 1) {
                    increase = 1;
                    decrease = 1;
                    flag = 1;
                }
            } else if (nums[i] < nums[i - 1]) {
                if (decrease == 1 || flag == -1) {
                    flag = -1;
                    decrease++;
                    increase = 1;
                }
                if (flag != -1) {
                    decrease = 1;
                    increase = 1;
                    flag = -1;
                }
            } else {
                increase = 1;
                decrease = 1;
                flag = 0;
            }

            res = Math.max(res, Math.max(increase, decrease));
        }

        return res;
    }
}
