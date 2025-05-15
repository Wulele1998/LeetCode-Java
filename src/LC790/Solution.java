package LC790;

public class Solution {
    public int numTilings(int n) {
        // time: O(N)
        // space: O(N)
        int MOD = 1_000_000_007;
        long[] dpFull = new long[n + 1];
        long[] dpPartial = new long[n + 1];
        if (n <= 2) {
            return n;
        }

        dpFull[1] = 1;
        dpFull[2] = 2;
        dpPartial[1] = 0;
        dpPartial[2] = 2;

        for (int i = 3; i <= n; i++) {
            dpPartial[i] = (dpFull[i - 2] * 2 + dpPartial[i - 1]) % MOD;
            dpFull[i] = (dpFull[i - 1] + dpFull[i - 2] + dpPartial[i - 2]) % MOD;
        }

        return (int) dpFull[n];
    }
}
