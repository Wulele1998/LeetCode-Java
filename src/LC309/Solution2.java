package LC309;

import java.util.Arrays;

/**
 * LC 309. Best Time to Buy and Sell Stock with Cooldown
 */
public class Solution2 {
    private int[][] memo;
    public int maxProfit(int[] prices) {
        // top-down DP
        memo = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            Arrays.fill(memo[i], -1); // initialize the memo
        }

        return dfs(prices, 0, false);
    }

    private int dfs(int[] prices, int day, boolean isHoldingStock) {
        if (day >= prices.length) {
            return 0;
        }

        if (isHoldingStock) {
            // currently we are holding the stock
            if (memo[day][1] != -1) {
                return memo[day][1];
            }
            int sellStock = prices[day] + dfs(prices, day + 2, false);
            int holdStock = dfs(prices, day + 1, true);
            memo[day][1] = Math.max(sellStock, holdStock);
        } else {
            if (memo[day][0] != -1) {
                return memo[day][0];
            }
            int buyStock = -prices[day] + dfs(prices, day + 1, true);
            int holdStock = dfs(prices, day + 1, false);
            memo[day][0] = Math.max(buyStock, holdStock);
        }

        return isHoldingStock ? memo[day][1] : memo[day][0];
    }
}
