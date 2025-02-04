package LC402;

import java.util.Stack;

/**
 * LC 402. Remove K Digits
 */
public class Solution {
    public String removeKdigits(String num, int k) {
        // N: the length of num
        // time: O(N)
        // space: O(N)
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (char c : stack) {
            if (c == '0' && flag){
                continue;
            }
            flag = false;
            sb.append(c);
        }

        if (sb.isEmpty())
            return "0";

        return sb.toString();
    }
}
