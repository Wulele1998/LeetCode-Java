package LC2914;

/**
 * LC 2914. Minimum Number of Changes to Make Binary String Beautiful
 */
public class Solution {
    public int minChanges(String s) {
        // N: the length of `s`
        // time: O(N)
        // space: O(1)
        int op = 0;

        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                op++;
            }
        }

        return op;
    }
}
