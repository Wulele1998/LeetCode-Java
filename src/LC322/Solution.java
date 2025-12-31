package LC322;

import java.util.Arrays;

/**
 * LC 322. Coin Change
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        // N: the number of coins
        // M: the `amount`
        // time: O(M * N)
        // space: O(M)

        // Dynamic programming
        // edge case 1: `amount` == 0
        // edge case 2: `amount` is less than is minimum coin

        // start DP
        // `dp[i]` means the fewest number of coin can make up the amount `i`
        // base case: each coin amount should be 1
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // initialize the dp array

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
