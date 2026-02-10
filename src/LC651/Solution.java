package LC651;

/**
 * LC 651. 4 Keys Keyboard
 */
public class Solution {
    public int maxA(int n) {
        // DP
        // N: n
        // time: O(N)
        // space: O(N)
        // Ctrl A + Ctrl C + Ctrl V needs 3 step
        if (n <= 3) {
            return n; // edge case
        }

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // use key "A"
        }

        // dp[i] = l
        // dp[i + 3] = 2l
        // dp[i + 4] = 2l + l / Ctrl A 2l
        // dp[i + 5] = 2l + l + l / Ctrl C 2l
        // dp[i + 6] = 2l + l + l + l / Ctrl V 4l
        // dp[i + 7] = 2l + l + l + l + l / Ctrl V 6l
        for (int i = 0; i <= n; i++) {
            for (int j = i + 3; j <= Math.min(i + 6, n); j++) {
                dp[j] = Math.max(dp[j], dp[i] * (j - i - 1));
            }
        }

        return dp[n];
    }
}
