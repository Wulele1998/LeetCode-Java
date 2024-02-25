package LC682;

import java.util.Stack;

public class Solution {
    public int calPoints(String[] operations) {
        // N: the length of `operations`
        // time: O(N)
        // space: O(N)
        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {
            if (op.equals("+")) {
                int num1 = stack.pop();
                int sum = num1 + stack.peek();
                stack.push(num1);
                stack.push(sum);
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(op));
            }
        }

        int res = 0;
        for (int num : stack) {
            res += num;
        }

        return res;
    }
}
