package LC309;

public class Solution {
    public int maxProfit(int[] prices) {
        // Dynamic Programming
        // N: the length of `prices`
        // time: O(N)
        // space: O(1)
        int sold = Integer.MIN_VALUE;
        int held = Integer.MIN_VALUE;
        int reset = 0;

        for (int price : prices) {
            int preSold = sold;
            sold = held + price; // sell the stock
            held = Math.max(held, reset - price); // buy the stock
            reset = Math.max(reset, preSold); // keep calm
        }

        return Math.max(reset, sold);
    }
}
