package LC1759;

public class Solution {
    public int countHomogenous(String s) {
        // N: the length of string
        // time complexity: O(N)
        // space: O(1)
        final int MOD = 1_000_000_007;
        char prev = s.charAt(0);
        long len = 1L;
        long res = 0L;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == prev) {
                len++;
            } else {
                res += len * (len + 1) / 2 % MOD;
                // update the previous character and reset the length back to 1
                prev = s.charAt(i);
                len = 1;
            }
        }
        res += len * (len + 1) / 2 % MOD;

        return (int) res;
    }
}
