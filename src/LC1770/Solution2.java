package LC1770;

public class Solution2 {
    public int maximumScore(int[] nums, int[] multipliers) {
        // dp[i][j]: max score of using first i-th numbers and last j-th numbers
        // Dynamic Programming: bottom up
        // N: the length of `nums`
        // M: the length of `multipliers`
        // time: O(M * M)
        // space: O(M * M)
        int n = nums.length;
        int m = multipliers.length;
        int[][] dp = new int[m + 1][m + 1];

        for (int op = 1; op <= m; op++) {
            for (int i = 0, j = op - i; i <= op; i++, j--) {
                int chooseLeft = i == 0 ? Integer.MIN_VALUE : nums[i - 1] * multipliers[op - 1] + dp[i - 1][j];
                // the padding
                // j = 1, index = n - 1
                // j = 2, index = n - 2
                // => index: n - j
                // i = 1, index = 0
                // i = 2, index = 1
                // => index: i - 1
                int chooseRight = j == 0 ? Integer.MIN_VALUE : nums[n - j] * multipliers[op - 1] + dp[i][j - 1];
                dp[i][j] = Math.max(chooseLeft, chooseRight);
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i <= m; i++) {
            res = Math.max(res, dp[i][m - i]);
        }

        return res;
    }

}
