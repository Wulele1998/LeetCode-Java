package LC727;

import java.util.Arrays;

public class Solution3 {
    public static final int INF = Integer.MAX_VALUE;
    public String minWindow(String s1, String s2) {
        // DP bottom-up
        // M: the length of `s1`
        // N: the length of `s2`
        // time: O(M * N)
        // space: O(M * N)
        int m = s1.length();
        int n = s2.length();
        if (m < n) {
            return "";
        }
        int[][] dp = new int[m + 1][n + 1];
        // dp[i][j]: the minimum length of substring start from i at s1 that contains s2[j:] as subsequence
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (j == n) {
                    // s2[j:] is empty, so the length of s1 subsequence window size is 0
                    dp[i][j] = 0;
                } else if (i == m) {
                    // s1[i:] is empty, it cannot match any string s2
                    continue;
                } else {
                    if (s1.charAt(i) == s2.charAt(j) && dp[i + 1][j + 1] != INF) {
                        dp[i][j] = 1 + dp[i + 1][j + 1];
                    }
                    if (s1.charAt(i) != s2.charAt(j) && dp[i + 1][j] != INF) {
                        dp[i][j] = 1 + dp[i + 1][j];
                    }
                }
            }
        }

        String res = "";
        int minWindowSize = m + 1;
        for (int i = 0; i < m; i++) {
            if (dp[i][0] < minWindowSize) {
                minWindowSize = dp[i][0];
                res = s1.substring(i, i + minWindowSize);
            }
        }

        return res;
    }
}
