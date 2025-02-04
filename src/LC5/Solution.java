package LC5;

/**
 * LC 5. Longest Palindromic Substring
 */
public class Solution {
    public String longestPalindrome(String s) {
        // Brute Force
        // N: the length of `s`
        // time: O(N ^ 3)
        // space: O(1)
        int n = s.length();
        String res = "";

        for (int start = 0; start < n; start++) {
            for (int end = start + 1; end <= n; end++) {
                // [start, end)
                if (isPalindrome(s.substring(start, end))) {
                    if (end - start > res.length()) {
                        res = s.substring(start, end);
                    }
                }
            }
        }

        return res;
    }

    private boolean isPalindrome(String s) {
        // N: the length of `s`
        // time: O(N)
        // space: O(1)
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }
}
