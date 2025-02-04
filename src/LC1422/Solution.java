package LC1422;

/**
 * LC 1422. Maximum Score After Splitting a String
 */
public class Solution {
    public int maxScore(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int ones = 0;
        int zeros = 0;
        int res = 0;

        for (char c : chars) {
            if (c == '1') {
                ones++;
            }
        }

        // cannot be empty string
        for (int i = 0; i < n - 1; i++) {
            if (chars[i] == '0') {
                zeros++;
            } else {
                ones--;
            }

            res = Math.max(res, ones + zeros);
        }

        return res;
    }
}
