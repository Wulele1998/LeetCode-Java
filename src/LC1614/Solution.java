package LC1614;

/**
 * LC 1614. Maximum Nesting Depth of the Parentheses
 */
public class Solution {
    public int maxDepth(String s) {
        // N: the length of `s`
        // time: O(N)
        // space: O(1)
        int res = 0;
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }

            res = Math.max(res, count);
        }

        return res;
    }
}
