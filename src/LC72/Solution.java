package LC72;

import java.util.Arrays;

public class Solution {
    private int[][] memo;
    public int minDistance(String word1, String word2) {
        // DP top-down memoization
        // memo[i][j]: minimum operation need for word1[i:], word2[j:] to make them equal
        // M: the length of `word1`
        // N: the length of `word2`
        // time: O(M * N)
        // space: O(M * N)
        int n1 = word1.length();
        int n2 = word2.length();
        memo = new int[n1][n2];

        for (int[] row : memo) {
            Arrays.fill(row, -1); // initialize `memo`
        }

        return minDistanceHelper(word1, word2, 0, 0);
    }

    private int minDistanceHelper(String word1, String word2, int index1, int index2) {
        if (index1 == word1.length() && index2 == word2.length()) {
            return 0;
        }
        if (index1 == word1.length()) {
            return word2.length() - index2;
        }
        if (index2 == word2.length()) {
            return word1.length() - index1;
        }
        if (memo[index1][index2] != -1) {
            return memo[index1][index2];
        }

        int res;
        if (word1.charAt(index1) == word2.charAt(index2)) {
            res = minDistanceHelper(word1, word2, index1 + 1, index2 + 1);
        } else {
            res = 1 + minDistanceHelper(word1, word2, index1 + 1, index2 + 1); // modify one of strings to match
            res = Math.min(1 + minDistanceHelper(word1, word2, index1 + 1, index2), res); // delete word1 character
            res = Math.min(1 + minDistanceHelper(word1, word2, index1, index2 + 1), res); // delete word2 character
        }
        memo[index1][index2] = res;

        return memo[index1][index2];
    }
}
