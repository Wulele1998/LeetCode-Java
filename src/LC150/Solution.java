package LC150;

import java.util.HashSet;
import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        // N: the length of `tokens`
        // time: O(N)
        // space: O(N) => stack
        Stack<Integer> stack = new Stack<>();
        HashSet<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");

        for (String token : tokens) {
            if (set.contains(token)) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                    case "-":
                        stack.push(num2 - num1);
                    case "*":
                        stack.push(num2 * num1);
                    case "/":
                        stack.push(num2 / num1);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
