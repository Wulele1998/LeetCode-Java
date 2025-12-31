package LC1143;

/**
 * LC 1143. Longest Common Subsequence
 */
public class Solution2 {
    public int longestCommonSubsequence(String text1, String text2) {
        // Dynamic Programming bottom-up
        // M: the length of `text1`
        // N: the length of `text2`
        // time: O(M * N)
        // space: O(M * N)
        int m = text1.length();
        int n = text2.length();
        // dp[i][j]: the longest common subsequence between text1[i ... m] and text2[j ... n]
        int[][] dp = new int[m + 1][n + 1]; // need to add padding

        // base case
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[m][i] = 0;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[0][0];
    }
}
