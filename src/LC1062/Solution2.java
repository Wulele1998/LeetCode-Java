package LC1062;

import java.util.Arrays;

/**
 * LC 1062. Longest Repeating Substring
 */
public class Solution2 {
    public int longestRepeatingSubstring(String s) {
        // N: the length of `s`
        // time: O(N ^ 2 * log N)
        // space: O(N ^ 2)
        int n = s.length();
        String[] suffixes = new String[n];

        for (int i = 0; i < n; i++) {
            suffixes[i] = s.substring(i);
        }

        Arrays.sort(suffixes);

        int maxLength = 0;

        for (int i = 1; i < n; i++) {
            int j = 0;
            while (j < Math.min(suffixes[i].length(), suffixes[i - 1].length()) && suffixes[i].charAt(j) == suffixes[i - 1].charAt(j)) {
                j++;
            }
            maxLength = Math.max(maxLength, j);
        }

        return maxLength;
    }
}
