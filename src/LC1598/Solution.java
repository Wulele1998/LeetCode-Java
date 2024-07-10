package LC1598;

import java.util.Stack;

/**
 * LC 1598. Crawler Log Folder
 */
public class Solution {
    public int minOperations(String[] logs) {
        // N: the number of logs
        // time: O(N)
        // space: O(N)
        Stack<String> stack = new Stack<>();
        for (String log : logs) {
            if (log.equals("../")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (log.equals("./")) {
                continue;
            } else {
                stack.push("x");
            }
        }

        return stack.size();
    }
}
