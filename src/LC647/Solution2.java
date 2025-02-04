package LC647;

public class Solution2 {
    public int countSubstrings(String s) {
        // DP
        // N: the length of `s`
        // time: O(N ^ 2)
        // space: O(N ^ 2)
        int n = s.length();
        int res = 0;
        // dp[i][j] means whether string [i, j] is palindromic
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++, res++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            res += dp[i][i + 1] ? 1 : 0;
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0, j = len + i - 1; j < n; i++, j++) {
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                res += dp[i][j] ? 1 : 0;
            }
        }

        return res;
    }
}
