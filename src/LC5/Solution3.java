package LC5;

/**
 * LC 5. Longest Palindromic Substring
 */
public class Solution3 {
    public String longestPalindrome(String s) {
        // Expand Around Center
        // N: the length of `s`
        // time: O(N ^ 2)
        // space: O(1)
        int n = s.length();
        // [start, end]
        int start = 0;
        int end = 0;
        int res = 1;
        for (int i = 0; i < n; i++) {
            // odd length
            int lenOdd = expendAroundCenter(s, i, i);
            // even length
            int lenEven = expendAroundCenter(s, i, i + 1);
            int lenMax = Math.max(lenOdd, lenEven);
            if (lenMax > res) {
                start = i - (lenMax - 1) / 2;
                end = i + lenMax / 2;
                res = lenMax;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expendAroundCenter(String s, int left, int right) {
        // N: the length of `s`
        // time: O(N)
        // space: O(1)
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // (left, right)
        return right - left - 1;
    }
}
