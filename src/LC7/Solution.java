package LC7;

public class Solution {
    public int reverse(int x) {
        // N: the value of `x`
        // time: O(log10 N) => O(1)
        // space: O(1)
        final int MAX_LAST_DIGIT = Integer.MAX_VALUE % 10;
        final int MIN_LAST_DIGIT = Integer.MIN_VALUE % 10;
        int res = 0;

        while (x != 0) {
            // x != 0 since we have both positive and negative number
            // get each digit of x
            int digit = x % 10;
            x /= 10;
            // overflow
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > MAX_LAST_DIGIT)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && digit < MIN_LAST_DIGIT)) {
                return 0;
            }
            res = res * 10 + digit;
        }

        return res;
    }
}
