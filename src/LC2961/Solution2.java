package LC2961;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        // N: the number of `variables`
        // M: the number of iteration
        // time: O(N * log M)
        // space: O(N)
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < variables.length; i++) {
            int[] var = variables[i];
            if (powMod(powMod(var[0], var[1], 10), var[2], var[3]) == target) {
                res.add(i);
            }
        }

        return res;
    }

    private int powMod(int x, int n, int mod) {
        if (n == 0)
            return 1;
        if ((n & 1) == 0) {
            // n is an even number
            // (x ^ n) % mod = (x ^ 2) ^ (n / 2) % mode =
            return powMod(x * x % mod, n / 2, mod) % mod;
        } else {
            // n is an odd number
            return x * powMod(x * x % mod, (n - 1) / 2, mod) % mod;
        }
    }
}
