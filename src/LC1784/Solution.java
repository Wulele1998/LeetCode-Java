package LC1784;

/**
 * March 6, 2026
 * LC 1784. Check if Binary String Has at Most One Segment of Ones
 */
public class Solution {
    public boolean checkOnesSegment(String s) {
        // N: the length of `s`
        // time: O(N)
        // space: O(1)
        boolean hasZero = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                hasZero = true;
            }
            if (hasZero && s.charAt(i) == '1') {
                return false;
            }
        }

        return true;
    }
}
