package LC678;

/**
 * LC 678. Valid Parenthesis String
 */
public class Solution {
    public boolean checkValidString(String s) {
        // N: the length of `s`
        // time: O(N)
        // space: O(N)
        int n = s.length();
        int openCount = 0;
        int closeCount = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                openCount++;
            } else {
                openCount--;
            }

            if (s.charAt(n - 1 - i) == ')' || s.charAt(n - 1 - i) == '*') {
                closeCount++;
            } else {
                closeCount--;
            }

            if (closeCount < 0 || openCount < 0) {
                return false;
            }
        }

        return true;
    }
}
