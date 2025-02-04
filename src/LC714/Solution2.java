package LC714;

public class Solution2 {
    public int maxProfit(int[] prices, int fee) {
        // Dynamic Programming
        // N: the length of `prices`
        // time: O(N)
        // space: O(1)
        int n = prices.length;
        int buy = -prices[0] - fee;
        int sell = 0;

        for (int i = 1; i < n; i++) {
            int buyTemp = buy;
            buy = Math.max(buy, sell - prices[i] - fee);
            sell = Math.max(sell, buyTemp + prices[i]);
        }

        return sell;
    }
}
