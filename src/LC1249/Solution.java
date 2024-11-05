package LC1249;

import java.util.HashSet;
import java.util.Stack;

/**
 * LC 1249. Minimum Remove to Make Valid Parentheses
 */
public class Solution {
    public String minRemoveToMakeValid(String s) {
        // N: the length of `s`
        // time: O(N)
        // space: O(N)
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    set.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        set.addAll(stack);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
