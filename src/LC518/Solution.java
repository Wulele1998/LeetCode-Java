package LC518;

/**
 * LC 518. Coin Change II
 */
public class Solution {
    public int change(int amount, int[] coins) {
        // Dynamic programming problem
        // edge case: when `amount` is 0, return 0
        // base case: each coin amount should be set 1
        // translation: dp[i] = Sum(dp[i - coin_j]), j from 0 to coin.length - 1

        // bottom up, tabulation
        int[] dp = new int[amount + 1];
        // base case
        dp[0] = 0;
        for (int coin : coins) {
            dp[coin] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i > coin) {
                    dp[i] += dp[i - coin];
                }
            }
        }



        return dp[amount];
    }
}
