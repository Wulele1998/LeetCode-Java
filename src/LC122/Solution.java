package LC122;

public class Solution {
    public int maxProfit(int[] prices) {
        // N: the length of `prices`
        // time: O(N)
        // space: O(1)
        int maxProfit = 0;
        int n = prices.length;

        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }
}
