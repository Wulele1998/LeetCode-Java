package LC1768;

public class Solution {
    public String mergeAlternately(String word1, String word2) {
        // M: the length of `word1`
        // N: the length of `word2`
        // time: O(M + N)
        // space: O(M + N)
        int m = word1.length();
        int n = word2.length();
        char[] res = new char[m + n];
        int i = 0;
        int j = 0;
        int index = 0;

        while (i < m || j < n) {
            if (i < m) {
                res[index++] = word1.charAt(i++);
            }
            if (j < n) {
                res[index++] = word2.charAt(j++);
            }
        }

        return String.valueOf(res);
    }
}
