package LC3174;

import java.util.Stack;

/**
 * LC 3174. Clear Digits
 */
public class Solution {
    public String clearDigits(String s) {
        // N: the length of `s`
        // time: O(N)
        // space: O(N), stack space
        // using stack
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)){
                if (!stack.isEmpty()){
                    stack.pop(); // remove the closest character
                }
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
