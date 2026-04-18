package LC10;

public class Solution3 {
    public boolean isMatch(String s, String p) {
        // M: the length of `s`
        // N: the length of `p`
        // time: O(M * N)
        // space: O(M * N)
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        // dp[i][j]: whether s.substring(i - 1) and p.substring(j - 1) can be matched

        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m && j == n) {
                    // both main string and pattern are empty
                    dp[i][j] = true;
                } else if (i == m) {
                    // main string is empty
                    // use * to remove its preceding character to make it match empty string
                    if (j + 1 < n && p.charAt(j + 1) == '*') {
                        dp[i][j] = dp[i][j + 2];
                    } else {
                        dp[i][j] = false;
                    }
                } else if (j == n) {
                    // pattern string is empty
                    dp[i][j] = false;
                } else {
                    boolean isMatch = s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';
                    // option 1: match => both move to next dp[i + 1][j + 1]
                    // option 2: match && p next char is '*' => "*" as repeat => dp[i + 1][j]
                    // option 3: match && p next char is '*' => "*" as remove => dp[i][j + 2];
                    // option 4: !match && p next char is '*' => '*' as remove => dp[i][j + 2];
                    dp[i][j] = isMatch && (dp[i + 1][j + 1] || (j + 1 < n && p.charAt(j + 1) == '*' && dp[i + 1][j])); // option 1 and 2
                    dp[i][j] = dp[i][j] || (j + 1 < n && p.charAt(j + 1) == '*' && dp[i][j + 2]); // option 3 and 4

                }
            }
        }

        return dp[0][0];
    }
}
