package LC97;

public class Solution3 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if (n1 + n2 != n3) {
            return false;
        }
        int[][] memo = new int[n1][n2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                memo[i][j] = -1;
            }
        }

        return backtrackMemo(s1, s2, s3, 0, 0, 0, memo);
    }

    private boolean backtrackMemo(String s1, String s2, String s3, int i, int j, int k, int[][] memo) {
        if (k == s3.length()) {
            return true;
        }
        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k) && backtrackMemo(s1, s2, s3, i + 1, j, k + 1, memo)) {
            memo[i][j] = 1;
            return true;
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k) && backtrackMemo(s1, s2, s3, i, j + 1, k + 1, memo)) {
            memo[i][j] = 1;
            return true;
        }

        memo[i][j] = 0;
        return false;
    }
}
