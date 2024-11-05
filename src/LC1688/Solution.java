package LC1688;

public class Solution {
    public int numberOfMatches(int n) {
        // N: `n`
        // time: O(log N)
        // space: O(1)
        int res = 0;

        while (n > 1) {
            if ((n & 1) == 1) {
                res += (n - 1) / 2;
                n = (n + 1) / 2;
            } else {
                res += n / 2;
                n /= 2;
            }
        }

        return res;
    }
}
