package LC2706;

public class Solution {
    public int buyChoco(int[] prices, int money) {
        // N: the length of `prices`
        // time: O(N)
        // space: O(1)
        int cheapest = Math.min(prices[0], prices[1]);
        int cheapest2 = Math.max(prices[0], prices[1]);
        
        for (int i = 2; i < prices.length; i++) {
            if (prices[i] <= cheapest) {
                cheapest2 = cheapest;
                cheapest = prices[i];
            } else if (prices[i] < cheapest2) {
                cheapest2 = prices[i];
            }
        }

        int sum = cheapest + cheapest2;
        return sum <= money ? money - sum : money;
    }
}
