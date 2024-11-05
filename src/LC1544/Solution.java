package LC1544;

import java.util.Stack;
/**
 * LC 1544. Make The String Great
 */
public class Solution {
    public String makeGood(String s) {
        // N: the length of `s`
        // time: O(N)
        // space: O(N)
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                char peekChar = stack.peek();
                if (Math.abs(c - peekChar) == 32) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
