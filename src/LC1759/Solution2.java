package LC1759;

public class Solution2 {
    public int countHomogenous(String s) {
        // N: the length of string
        // time complexity: O(N)
        // space: O(1)
        final int MOD = 1_000_000_007;
        int n = s.length();
        char[] chars = s.toCharArray();
        long res = 0L;
        int i = 0;
        while (i < n) {
            int start = i;
            char startChar = chars[i];
            i++;
            while (i < n && chars[i + 1] == startChar) {
                i++;
            }
            res += (long) (i - start) * (i - start + 1) >> 1 % MOD;
        }

        return (int) (res % MOD);
    }
}
