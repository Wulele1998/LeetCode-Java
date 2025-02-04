package LC8;

public class Solution {
    public int myAtoi(String s) {
        // N: the length of `s`
        // time: O(N)
        // space: O(1)
        final int MAX_LAST_DIGIT = Integer.MAX_VALUE % 10;
        int sign = 1;
        int index= 0;
        int n = s.length();
        int res = 0;

        // discard all whitespace at the beginning of the input string
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }
        if (s.charAt(index) == '-') {
            // negative number
            sign = -1;
            index++;
        } else if (s.charAt(index) == '+') {
            // positive number may have the + mark
            index++;
        }

        // find the number
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > MAX_LAST_DIGIT)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = 10 * res + digit;
            index++;
        }

        return res;
    }
}
