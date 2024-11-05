package LC121;

public class Solution {
    public int maxProfit(int[] prices) {
        // Dynamic Programming
        // N: the length of `prices`
        // time: O(N)
        // space: O(1)
        int lowest = prices[0];
        int maxProfit = 0;
        int n = prices.length;

        for (int i = 1; i < n; i++) {
            if (lowest > prices[i]) {
                lowest = prices[i];
            }
            maxProfit = Math.max(maxProfit, prices[i] - lowest);
        }

        return maxProfit;
    }
}
