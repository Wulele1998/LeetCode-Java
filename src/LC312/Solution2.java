package LC312;

public class Solution2 {
    public int maxCoins(int[] nums) {
        // DP bottom-up
        // N: the length of `nums`
        // time: O(N ^ 3)
        // space: O(N ^ 2)
        int n = nums.length;
        int[] numsExt = new int[n + 2];
        numsExt[0] = 1;
        numsExt[n + 1] = 1;
        System.arraycopy(nums, 0, numsExt, 1, n);

        int[][] dp = new int[n + 2][n + 2];
        for (int left = n; left >= 1; left--) {
            for (int right = left; right <= n; right++) {
                for (int i = left; i <= right; i++) {
                    int maxCoins = numsExt[left - 1] * numsExt[i] * numsExt[right + 1];
                    int maxCoinsLeft = dp[left][i - 1];
                    int maxCoinsRight = dp[i + 1][right];
                    dp[left][right] = Math.max(dp[left][right], maxCoins + maxCoinsLeft + maxCoinsRight);
                }
            }
        }

        return dp[1][n];
    }
}
