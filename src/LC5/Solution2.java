package LC5;

/**
 * LC 5. Longest Palindromic Substring
 */
public class Solution2 {
    public String longestPalindrome(String s) {
        // Dynamic Programming
        // N: the length of `s`
        // time: O(N ^ 2)
        // space: O(N ^ 2)
        int n = s.length();
        int start = 0;
        int end = 0;
        int resLength = 1;
        // dp[i][j] is true means [i, j] substring is palindrome
        boolean[][] dp = new boolean[n][n];

        // base case
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            // default the length is 1
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                // update the length of 2
                dp[i][i + 1] = true;
                start = i;
                end = i + 1;
                resLength = 2;
            }
        }

        // transition equation
        // s[i] == s[j] and dp[i+1][j-1] is true => dp[i][j] is true
        for (int i = n - 1; i >= 0; i--) {
            // since we get the value of dp[i][] from dp[i+1][]
            // we should inverse traversal on i
            for (int j = i + 2; j < n; j++) {
                // since we get the value of dp[][j] from dp[][j-1]
                // we should normal traversal on j
               if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                   // upload the length
                   dp[i][j] = true;
                   if (j - i + 1 > resLength) {
                       resLength = j - i + 1;
                       start = i;
                       end = j;
                   }
               }
            }
        }

        return s.substring(start, end + 1);
    }
}
