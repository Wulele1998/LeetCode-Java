package LC1049;

import java.util.Arrays;

public class Solution {
    private int[][] memo;
    public int lastStoneWeightII(int[] stones) {
        // top down DP
        int sum = 0;

        for (int stone : stones) {
            sum += stone;
        }

        memo = new int[stones.length][sum];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        dfs(stones, 0, 0, 0);
        return memo[0][0];
    }

    private int dfs(int[] stones, int index, int sum1, int sum2) {
        if (index == stones.length) {
            return Math.abs(sum1 - sum2);
        }

        if (memo[index][sum1] != -1)
            return memo[index][sum1];
        // option 1: add stone[index] into sum1
        // option 2: add stone[index] into sum2
        memo[index][sum1] = Math.min(dfs(stones, index + 1, sum1 + stones[index], sum2), dfs(stones, index + 1, sum1, sum2 + stones[index]));

        return memo[index][sum1];
    }
}
