package LC647;

public class Solution {
    public int countSubstrings(String s) {
        // DP
        // N: the length of `s`
        // time: O(N ^ 2)
        // space: O(N ^ 2)
        int n = s.length();
        int res = 0;
        // dp[i][j] means whether string [i, j] is palindromic
        boolean[][] dp = new boolean[n][n];
        // base case: dp[i][i] = true
        // s[i] == s[i + 1] -> dp[i][i + 1] = true
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            res++;
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                res++;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }

        return res;
    }
}
