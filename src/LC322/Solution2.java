package LC322;

import java.util.Arrays;

public class Solution2 {
    private int[] memo; // memo[i] the fewest number of coins need for amount i
    public static final int INF = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, INF);

        return topDownDPHelper(coins, amount);
    }

    private int topDownDPHelper(int[] coins, int amount) {
        // base case
        if (amount == 0) {
            return 0; // no coins needed
        }
        if (amount < 0) {
            return -1;
        }

        if (memo[amount] != INF) {
            return memo[amount];
        }

        int res = INF;
        for (int coin : coins) {
            int coinNum = topDownDPHelper(coins, amount - coin);
            if (coinNum != -1) {
                res = Math.min(res, 1 + coinNum);
            }
        }

        memo[amount] = res == INF ? -1 : res;
        return memo[amount];
    }
}
