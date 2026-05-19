package LC5;

public class Solution5 {
    private Boolean[][] memo; // memo[i][j] means whether s[i : j + 1] is palindrome
    // null: unknown yet
    // true: s[i : j + 1] is palindrome
    // false: s[i : j + 1] is not a palindrome
    private int maxLen;
    private String res;
    public String longestPalindrome(String s) {
        // top down DP
        if (s.isEmpty()) {
            return "";
        }

        int n = s.length();
        maxLen = 1;
        res = s.substring(0, 1);
        memo = new Boolean[n][n];

        topDownDPHelper(s, 0, n - 1);

        return res;
    }

    private boolean topDownDPHelper(String s, int l, int r) {
        // base case: when the s[l : r + 1] length is 0 or 1, it is a palindrome
        if (l >= r)
            return true;

        if (memo[l][r] != null)
            return memo[l][r]; // check memo to avoid duplicate calculation

        if (s.charAt(l) == s.charAt(r) && topDownDPHelper(s, l + 1, r - 1)) {
            memo[l][r] = true;
            if (r - l + 1 > maxLen) {
                maxLen = r - l + 1;
                res = s.substring(l, r + 1);
            }
        } else {
            memo[l][r] = false;
        }

        topDownDPHelper(s, l, r - 1);
        topDownDPHelper(s, l + 1, r);

        return memo[l][r];
    }
}
