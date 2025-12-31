package LC2110;

/**
 * Dec 15, 2025
 * LC 2110. Number of Smooth Descent Periods of a Stock
 */
public class Solution {
    public long getDescentPeriods(int[] prices) {
        // N: the length of `prices`
        // time: O(N)
        // space: O(1)
        int prevCount = 0;
        long res = 0L;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                prevCount++;
            } else {
                if (prices[i - 1] - prices[i] == 1) {
                    prevCount++;
                } else {
                    prevCount = 1;
                }
            }

            res += prevCount;
        }

        return res;
    }
}
