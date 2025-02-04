package LC459;

public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        // brute force
        // N: the length of `s`
        // time: O(N ^ 2)
        // space: O(1)
        int n = s.length();

        for (int len = n / 2; len >= 1; len--) {
            // the length of repeat string
            if (n % len == 0) {
                String template = s.substring(0, len);
                int count = 1;
                for (int i = len; i < n; i += len) {
                    // O(N) when using string equals function
                    if (s.substring(i, i + len).equals(template)) {
                        count++;
                    }
                }

                if (count == n / len) {
                    return true;
                }
            }
        }

        return false;
    }
}
