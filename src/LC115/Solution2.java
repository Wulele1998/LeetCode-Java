package LC115;

public class Solution2 {
    public int numDistinct(String s, String t) {
        // DP bottom-up
        int m = s.length();
        int n = t.length();
        if (m < n) {
            return 0;
        }

        int[][] dp = new int[m + 1][n + 1];
        for (int i = m; i >= 0; i--) { // string s
            for (int j = n; j >= 0; j--) { // string t
                if (j == n) {
                    // string t[n:] is an empty string
                    dp[i][j] = 1;
                } else if (i == m) {
                    // string s[m:] is an empty string
                    dp[i][j] = 0;
                } else {
                    if (s.charAt(i) == t.charAt(j)) {
                        dp[i][j] += dp[i + 1][j + 1];
                    }
                    dp[i][j] += dp[i + 1][j];
                }
            }
        }

        return dp[0][0];
    }
}
