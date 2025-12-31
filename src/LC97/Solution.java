package LC97;

/**
 * LC
 */
public class Solution {
    // backtrack brute force
    public boolean isInterleave(String s1, String s2, String s3) {
        // M: the length of `s1`
        // N: the length of `s2`
        // time: O(2 ^ (M + N))
        // space: O(M + N), stack of recursive call
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if (n1 + n2 != n3) {
            return false;
        }

        return backtrack(s1, s2, s3, 0, 0, 0);
    }

    private boolean backtrack(String s1, String s2, String s3, int i, int j, int k) {
        if (k == s3.length()) {
            return true;
        }

        boolean res = false;
        if (i < s1.length() && k < s3.length() && s1.charAt(i) == s3.charAt(k)) {
            res |= backtrack(s1, s2, s3, i + 1, j, k + 1);
        }

        if (j < s2.length() && k < s3.length() && s2.charAt(j) == s3.charAt(k)) {
            res |= backtrack(s1, s2, s3, i, j + 1, k + 1);
        }

        return res;
    }
}
