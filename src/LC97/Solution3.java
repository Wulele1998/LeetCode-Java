package LC97;

import java.util.Arrays;

public class Solution3 {
    // M: the length s1
    // N: the length s2
    // time: O(M + N)
    // space: O(M * N)
    int[][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        // DP, top-down
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if (n1 + n2 != n3) {
            return false;
        }
        int[][] memo = new int[n1][n2];
        for (int i = 0; i < n1; i++) {
            Arrays.fill(memo[i], -1);
        }

        return backtrackMemo(s1, s2, s3, 0, 0);
    }

    private boolean backtrackMemo(String s1, String s2, String s3, int i, int j) {
        if (i == s1.length()) {
            return s2.substring(j).equals(s3.substring(i + j));
        }
        if (j == s2.length()) {
            return s1.substring(i).equals(s3.substring(i + j));
        }

        // have get the result
        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }

        if ((s1.charAt(i) == s3.charAt(i + j) && backtrackMemo(s1, s2, s3, i + 1, j))
                || (s2.charAt(j) == s3.charAt(i + j) && backtrackMemo(s1, s2, s3, i, j + 1))) {
            memo[i][j] = 1;
            return true;
        }

        memo[i][j] = 0;
        return false;
    }
}
