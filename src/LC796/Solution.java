package LC796;

/**
 * LC 796. Rotate String
 */
public class Solution {
    public boolean rotateString(String s, String goal) {
        // N: the length of `s`
        // time: O(N)
        // space: O(N)
        if (s.length() != goal.length())
            return false;

        String t = s + s;
        return t.contains(goal);
    }
}
