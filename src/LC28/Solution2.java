package LC28;

public class Solution2 {    
    public int strStr(String haystack, String needle) {
        // N: the length of `haystack`
        // M: the length of `needle`
        // time: O(M * N)
        // space: O(1)
        int n = haystack.length();
        int m = needle.length();

        if (n < m) {
            return -1;
        }

        for (int i = 0; i <= n - m; i++) {
            // start the compare from i of haystack
            for (int j = 0; j < m; j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break; // move the i to next one
                }
                
                if (j == m - 1) {
                    return i;
                }
            }
        }

        return -1;
    }
}
