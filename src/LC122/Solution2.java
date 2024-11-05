package LC122;

public class Solution2 {
    public int maxProfit(int[] prices) {
        // N: the length of `prices`
        // time: O(N)
        // space: O(1)
        int index = 0;
        int maxProfit = 0;
        int n = prices.length;
        int valley = prices[0];
        int peek = prices[0];

        while (index < n - 1) {
            // find the prices valley
            while (index < n - 1 && prices[index + 1] <= prices[index]) {
                index++;
            }
            valley = prices[index];

            // find the price peek
            while (index < n - 1 && prices[index + 1] > prices[index]) {
                index++;
            }
            peek = prices[index];

            maxProfit += peek - valley;
        }

        return maxProfit;
    }
}
