package LC459;

public class Solution2 {
    public boolean repeatedSubstringPattern(String s) {
        // N: the length of `S`
        // time: O(N * N ^ 1/2)
        // space: O(N)
        int n = s.length();
        for (int len = 1; len <= n / 2; len++) {
            if (n % len == 0) {
                StringBuilder sb = new StringBuilder();
                String sub = s.substring(0, len);
                sb.append(sub.repeat(n / len));

                if (s.contentEquals(sb)) {
                    return true;
                }
            }
        }

        return false;
    }
}
