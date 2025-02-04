package LC2486;

/**
 * LC 2486. Append Characters to String to Make Subsequence
 */
public class Solution {
    public int appendCharacters(String s, String t) {
        // two pointers
        // M: the length of `s`
        // N: the length of `t`
        // time: O(min(M, N))
        // space: O(1)

        int i = 0;
        int j = 0;
        
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
            i++;

        }
        
        return t.length() - j;
    }
}
