package LC91;

public class Solution {
    public int numDecodings(String s) {
        // Dynamic Programming
        // N: the length of `s`
        // time: O(N)
        // space: O(N)
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i < n + 1; i++) {
            // single digit
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            // two digit
            int val = Integer.parseInt(s.substring(i - 2, i));
            if (val >= 10 && val <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
