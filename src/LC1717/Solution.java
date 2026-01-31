package LC1717;

import java.util.Stack;

/**
 * LC 1717. Maximum Score From Removing Substrings
 */
public class Solution {
    int res = 0;
    public int maximumGain(String s, int x, int y) {
        // N: the length of `s`
        // time: O(N)
        // space: O(N)
        String higher = x >= y ? "ab" : "ba";
        String lower = higher.equals("ab") ? "ba" : "ab";

        String firstRound = removeSubstring(s, higher, Math.max(x, y));
        removeSubstring(firstRound, lower, Math.min(x, y));

        return res;

    }

    private String removeSubstring(String s, String sub, int score) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == sub.charAt(1) && !stack.isEmpty() && stack.peek() == sub.charAt(0)) {
                stack.pop();
                res += score;
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
