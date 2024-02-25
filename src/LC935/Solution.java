package LC935;


public class Solution {
    public int knightDialer(int n) {
        // DP
        // N: `n`
        // time: O(N)
        // space: O(N)
        final int MOD = 1_000_000_007;
        int res = 0;
        int[][] jump = new int[][] {
            {4, 6},
            {6, 8},
            {7, 9},
            {4, 8},
            {0, 3, 9},
            {},
            {0, 1, 7},
            {2, 6},
            {1, 3},
            {2, 4}
        };
    
        // use iterative for DP
        // bottom-up DP
        
        int[][] dp = new int[n][10];
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int move : jump[j]) {
                    dp[i][j] = (dp[i][j] +  dp[i - 1][move]) % MOD;
                }
            }
        }

        for (int num = 0; num < 10; num++) {
            res = (res + dp[n - 1][num]) % MOD;
        }

        return res;
    }
}
