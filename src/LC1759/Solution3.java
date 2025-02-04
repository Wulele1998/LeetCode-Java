package LC1759;

public class Solution3 {
    public int countHomogenous(String s) {
        // N: the length of string
        // time complexity: O(N)
        // space: O(1)
        final int MOD = 1_000_000_007;
        int n = s.length();
        int res = n;
        int len = 1;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                res = (res + len) % MOD;
                len++;
            } else {
                len = 1;
            }
        }

        return res;
    }
}
