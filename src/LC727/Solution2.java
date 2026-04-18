package LC727;

import java.util.Arrays;

public class Solution2 {
    // M: the length of `s1`
    // N: the length of `s2`
    // time: O(M * N)
    // space: O(M * N)
    public static final int INF = Integer.MAX_VALUE;
    private int[][] memo;

    public String minWindow(String s1, String s2) {
        // DP top-down
        int m = s1.length();
        int n = s2.length();
        if (m < n) {
            return "";
        }

        // memo[i][j]: the minimum length of substring start from i at s1 that contains s2[j:] as subsequence
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // initialize the memo as unvisited
        }

        topDownDFS(s1, s2, 0, 0);

        int minWindowSize = m + 1;
        String res = "";
        for (int i = 0; i < m; i++) {
            if (memo[i][0] < minWindowSize) {
                minWindowSize = memo[i][0];
                res = s1.substring(i, i + minWindowSize);
            }
        }

        return res;
    }

    private int topDownDFS(String s1, String s2, int index1, int index2) {
        // base case
        if (index2 == s2.length()) {
            // s2[index2:] is an empty string
            return 0;
        }

        if (index1 == s1.length()) {
            // s1[index1:] is an empty string, it cannot include any s2 as subsequence
            return INF;
        }

        if (memo[index1][index2] != -1) {
            return memo[index1][index2];
        }

        // option 1: s1.charAt(index1) == s2.charAt(index2), match and move to next
        // option 2: skip s1.charAT(index1) and check next
        int res = topDownDFS(s1, s2, index1 + 1, index2) == INF ? INF : 1 + topDownDFS(s1, s2, index1 + 1, index2);
        if (s1.charAt(index1) == s2.charAt(index2)) {
            res = Math.min(res, topDownDFS(s1, s2, index1 + 1, index2 + 1) == INF ? INF : 1 + topDownDFS(s1, s2, index1 + 1, index2 + 1));
        }
        memo[index1][index2] = res;

        return res;
    }
}
