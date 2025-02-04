package LC3110;

/**
 * LC 3110. Score of a String
 */
public class Solution {
    public int scoreOfString(String s) {
        // N: the length of `s`
        // time: O(N)
        // space: O(1)
        int n = s.length();
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum += s.charAt(i) - s.charAt(i - 1);
        }

        return sum;
    }
}