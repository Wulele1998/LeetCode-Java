package LC1143;

import java.util.Arrays;

/**
 * LC 1143. Longest Common Subsequence
 */
public class Solution {
    int m;
    int n;
    int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        // Dynamic Programming top-down, use recursion
        // memo[i][j] store the longest common subsequence between text1[i ... m] and text2[j ... n]
        // M: the length of `text1`
        // N: the length of `text2`
        // time: O(M * N)
        // space: O(M * N)
        m = text1.length();
        n = text2.length();
        memo = new int[m][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1); // init state
        }

        return DP(text1, text2, 0, 0);
    }

    /**
     * recursive function
     * @param text1 String text1
     * @param text2 String text2
     * @param i current index of `text1`
     * @param j current index of `text2`
     * @return the longest common subsequence between text1[0 ... i], text2[0 ... j]
     */
    private int DP(String text1, String text2, int i, int j) {
        // base case: the match has reached the end
        if (i == m || j == n) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j]; // avoid repeat calculation
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1 + DP(text1, text2, i + 1, j + 1);
        } else {
            memo[i][j] = Math.max(DP(text1, text2, i + 1, j), DP(text1, text2, i, j + 1));
        }

        return memo[i][j];
    }
}
