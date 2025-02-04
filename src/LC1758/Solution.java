package LC1758;

public class Solution {
    public int minOperations(String s) {
        // N: the length of `s`
        // time: O(N)
        // space: O(1)
        int n = s.length();
        int diff1 = 0, diff2 = 0;
        char[] chars = s.toCharArray();
        // diff1 1010101010 ...
        // diff2 0101010101 ...
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                // even
                if (chars[i] == '0') {
                    diff1++;
                } else {
                    diff2++;
                }
            } else {
                // odd
                if (chars[i] == '0') {
                    diff2++;
                } else {
                    diff1++;
                }
            }
        }

        return Math.min(diff1, diff2);
    }
}
