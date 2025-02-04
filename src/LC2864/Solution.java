package LC2864;

/**
 * LC 2864. Maximum Odd Binary Number
 */
public class Solution {
    public String maximumOddBinaryNumber(String s) {
        // N: the length of `s`
        // time: O(N)
        // space: O(1)
        int n = s.length();
        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1')
                ones++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i < ones - 1 || i == n - 1) {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }

        return sb.toString();
    }
}
