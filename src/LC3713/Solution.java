package LC3713;

/**
 * LC 3713. Longest Balanced Substring I
 */
public class Solution {
    public int longestBalanced(String s) {
        // N: the length of `s`
        // time: O(N ^ 2)
        // space: O(1)

        int res = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int[] counts = new int[26];
            int maxFreq = 0;
            int distCount = 0;
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (counts[c - 'a'] == 0) {
                    distCount++;
                }
                counts[c - 'a']++;
                maxFreq = Math.max(maxFreq, counts[c - 'a']);

                if (maxFreq * distCount == j - i + 1) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }

        return res;
    }
}
