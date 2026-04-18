package LC115;

import java.util.Arrays;

public class Solution {
    private int[][] memo;
    private int m; // length of string s
    private int n; // length of string t
    public int numDistinct(String s, String t) {
        m = s.length();
        n = t.length();
        memo = new int[m][n];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return topDownDFS(s, t, 0, 0);
    }

    /**
     * calculate the number of distinct subsequence between s[indexS:] and t[indexT:]
     * @param s string s
     * @param t string t
     * @param indexS current index of string s
     * @param indexT current index of string t
     * @return number of distinct subsequence
     */
    private int topDownDFS(String s, String t, int indexS, int indexT) {
        if (indexT == n) {
            return 1; // T has been fully matched
        }
        if (indexS == m) {
            return 0; // if indexS has reached the end but index T hasn't, no subsequence is found
        }
        if (memo[indexS][indexT] != -1) {
            return memo[indexS][indexT]; // check the memo to aovid repeat calculation (prune the decision tree)
        }
        int res = 0;
        if (s.charAt(indexS) == t.charAt(indexT)) {
            // match current two characters and both move to the next
            res += topDownDFS(s, t, indexS + 1, indexT + 1);
        }
        // either match or not match, we can skip current character at s, move to next
        res += topDownDFS(s, t, indexS + 1, indexT);
        memo[indexS][indexT] = res;

        return res;
    }
}