package LC97;

import java.util.Arrays;

public class Solution3 {
    // M: the length `s1`
    // N: the length `s2`
    // time: O(M * N)
    // space: O(M * N)
    public static final int MATCH = 1;
    public static final int NOT_MATCH = 0;
    public static final int UNKNOWN = -1;
    private int[][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        // DP top-down memoization
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        // length check
        if (n3 != n1 + n2) {
            return false;
        }

        memo = new int[n1 + 1][n2 + 1];
        // initialize the `memo`,
        for (int[] row : memo) {
            Arrays.fill(row, UNKNOWN);
        }

        return checkInterleave(s1, s2, s3, 0, 0) == MATCH;
    }

    private int checkInterleave(String s1, String s2, String s3, int index1, int index2) {
        // base case
        if (index1 == s1.length() && index2 == s2.length()) {
            return MATCH;
        }

        // check memo
        if (memo[index1][index2] != UNKNOWN) {
            return memo[index1][index2];
        }

        int res1 = UNKNOWN;
        int res2 = UNKNOWN;
        if (index1 < s1.length() && s1.charAt(index1) == s3.charAt(index1 + index2)) {
            res1 = checkInterleave(s1, s2, s3, index1 + 1, index2);
        }
        if (index2 < s2.length() && s2.charAt(index2) == s3.charAt(index1 + index2)) {
            res2 = checkInterleave(s1, s2, s3, index1, index2 + 1);
        }

        if (res1 == MATCH || res2 == MATCH) {
            memo[index1][index2] = MATCH;
        } else {
            memo[index1][index2] = NOT_MATCH;
        }

        return memo[index1][index2];
    }
}
