package LC28;

public class Solution {
    public int strStr(String haystack, String needle) {
        // string matching
        // slide window
        // M: the length of `haystack`
        // N: the length of `needle`
        // time: O(M * N)
        // space: O(1)
        int m = haystack.length();
        int n = needle.length();
        if (n > m) {
            return -1;
        }

        for (int i = 0; i <= m - n; i++) {
            // string equals function needs time O(N)
            if (haystack.substring(i, i + n).equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}
