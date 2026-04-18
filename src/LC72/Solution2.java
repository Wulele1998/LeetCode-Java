package LC72;

import java.util.Arrays;

public class Solution2 {
    public int minDistance(String word1, String word2) {
        // DP bottom-up tabulation
        // dp[i][j]: minimum operation need for word1[i:], word2[j:] to make them equal
        // M: the length of `word1`
        // N: the length of `word2`
        // time: O(M * N)
        // space: O(M * N)
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = n1; i >= 0; i--){
            for (int j = n2; j>= 0; j--) {
                if (i == n1 && j == n2) {
                    dp[i][j] = 0;
                } else if (i == n1) { // word1 is empty string
                    dp[i][j] = 1 + dp[i][j + 1]; // delete operation
                } else if (j == n2) { // word2 is empty string
                    dp[i][j] = 1 + dp[i + 1][j]; // delete operation
                } else {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else {
                        // option 1: modify word 1 or word 2
                        dp[i][j] = 1 + dp[i + 1][j + 1];
                        // option 2: delete word 1 character
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i + 1][j]);
                        // option 3: delete word 2 character
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j + 1]);
                    }
                }
            }
        }

        return dp[0][0];
    }
}
