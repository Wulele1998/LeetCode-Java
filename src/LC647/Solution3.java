package LC647;

public class Solution3 {
    // Top Down DP
    // N: the length of `s`
    // time: O(N ^ 2)
    // space: O(N ^ 2)
    private Boolean[][] memo;
    public int countSubstrings(String s) {
        int n = s.length();
        memo = new Boolean[n][n];

        topDownDPHelper(s, 0, n - 1);

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (memo[i][j]) {
                    res++;
                }
            }
        }

        return res;
    }

    private boolean topDownDPHelper(String s, int l, int r) {
        if (l > r)
            return true;

        if (memo[l][r] != null)
            return memo[l][r];

        if (l == r) {
            return memo[l][r] = true;
        }
        memo[l][r] = (s.charAt(l) == s.charAt(r) && topDownDPHelper(s, l + 1, r - 1));

        topDownDPHelper(s, l + 1, r);
        topDownDPHelper(s, l, r - 1);

        return memo[l][r];
    }
}
