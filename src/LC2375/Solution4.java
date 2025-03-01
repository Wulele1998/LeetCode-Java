package LC2375;

import java.util.Stack;

/**
 * LC 2375. Construct Smallest Number From DI String
 */
public class Solution4 {
    public String smallestNumber(String pattern) {
        // using stack
        // N: the length of pattern
        // time: O(N)
        // space: O(N)
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char[] pArr = pattern.toCharArray();

        for (int i = 0; i <= pArr.length; i++) {
            stack.push(i + 1);

            // if pArr[i] == 'D', keep pushing in to the stack, which need to be reversed
            if (i == pArr.length || pArr[i] == 'I') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
        }

        return sb.toString();
    }
}
