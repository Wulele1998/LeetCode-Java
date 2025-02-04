package LC935;

public class Solution2 {
    final int MOD = 1_000_000_007;
    final int[][] JUMP = new int[][] {
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
    final int MAX_LENGTH = 5_000;
    final int[][] cache = new int[MAX_LENGTH][10];

    public int knightDialer(int n) {
        // DP
        // N: `n`
        // time: O(N)
        // space: O(N)
        // recursive DP, top-down
        int[] digits = new int[10];
        for (int i = 0; i < 10; i++) {
            digits[i] = i;
        }
        return dp(n, digits);

    }

    private int dp(int lengthLeft, int[] nextNumbers) {
        if (lengthLeft == 1) {
            return nextNumbers.length;
        }

        int count = 0;
        
        for (int nextNum : nextNumbers) {
            int current = cache[lengthLeft][nextNum];
            // check the cache
            if (current == 0) {
                // not calculated
                current = dp(lengthLeft - 1, JUMP[nextNum]);
                cache[lengthLeft][nextNum] = count;
            }
            count = (count + current) % MOD;
        }

        return count;
    }
}
