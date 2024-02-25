package LC1716;

public class Solution2 {
    public int totalMoney(int n) {
        // N: `n`
        // time: O(N)
        // space: O(1)
        int res = 0;

        for (int i = 1; i <= n; i++) {
            if (i % 7 == 0) {
                res += 7 + (i / 7) - 1;
            } else {
                res += (i / 7) + (i % 7);
            }
        }

        return res;
    }
}
