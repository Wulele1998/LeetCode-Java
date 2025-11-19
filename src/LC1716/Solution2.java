package LC1716;

/**
 * Oct 25, 2025
 * LC 1716. Calculate Money in Leetcode Bank
 */
public class Solution2 {
    public int totalMoney(int n) {
        // N: `n`
        // time: O(N)
        // space: O(1)
        int res = 0;

        for (int i = 1; i <= n; i++) {
            if (i % 7 == 0) {
                res += 7 + (i / 7) - 1;
            } else {
                res += (i / 7) + (i % 7);
            }
        }

        return res;
    }
}
