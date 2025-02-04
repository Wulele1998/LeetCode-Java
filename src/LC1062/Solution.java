package LC1062;

import java.util.Set;
import java.util.HashSet;

/**
 * LC 1062. Longest Repeating Substring
 */
public class Solution {
    public int longestRepeatingSubstring(String s) {
        // N: the length of `s`
        // time: O(N ^ 3)
        // space: O(N)
        Set<String> seenSubstrings = new HashSet<>();
        int maxLength = s.length() - 1;

        int start = 0;
        // ATTENTION: start can be equal to s.length()
        while (start <= s.length()) {
            if (start + maxLength > s.length()) {
                maxLength--;
                if (maxLength == 0) {
                    return 0;
                }
                // the max length is updated
                seenSubstrings.clear();
                start = 0; // restart search
                continue;
            }

            String substring = s.substring(start, start + maxLength);
            if (seenSubstrings.contains(substring)) {
                return maxLength;
            } else {
                seenSubstrings.add(substring);
            }
            start++;
        }

        return maxLength;
    }
}
