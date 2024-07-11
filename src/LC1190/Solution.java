package LC1190;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * LC 1190. Reverse Substrings Between Each Pair of Parentheses
 */
public class Solution {
    public String reverseParentheses(String s) {
        // N: the length of `s`
        // time: O(N ^ 2)
        // space: O(N)
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                // reverse
                while (stack.peek() != '(') {
                    queue.add(stack.pop());
                }
                stack.pop(); // pop (

                while (!queue.isEmpty()) {
                    stack.push(queue.poll());
                }
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
