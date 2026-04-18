package LC10;

public class Solution2 {
    private Boolean[][] memo;
    private int m; // length of s
    private int n; // length of p
    public boolean isMatch(String s, String p) {
        // Dynamic Programming Top-Down
        // memo[i][j]: whether s[i:] can match p[j:]
        // case 1: s[i] == p[j] => DFS(i + 1, j + 1)
        // case 2: p[i] == '.' => DFS(i + 1, j + 1)
        // case 3: p[i] == '*' => (1) DFS(i, j + 1), * matches empty
        //                        (2) DFS(i, j - 1), * matches preceding character

        m = s.length();
        n = p.length();
        // true: match
        // false: not match
        // null: unvisited
        memo = new Boolean[m + 1][n + 1]; // True, False, Null 3 state

        return topDownDFS(s, p, 0, 0);
    }

    /**
     * @param s: string s (main string)
     * @param p: string pattern
     * @param indexS: the current index of string s
     * @param indexP: the current index of string p
     * @return whether s.substring(s) can match p.substring(p)
     */
    private boolean topDownDFS(String s, String p, int indexS, int indexP) {
        if (indexP == n) {
            return indexS == m;
        }

        // check the memo
        if (memo[indexS][indexP] != null) {
            return memo[indexS][indexP]; // avoid repeat calculation
        }

        boolean res;
        boolean firstMatch = indexS < m && (s.charAt(indexS) == p.charAt(indexP) || p.charAt(indexP) == '.');
        if (indexP + 1 < n && p.charAt(indexP + 1) == '*') {
            // 1. skip pattern current character and next *
            res = topDownDFS(s, p, indexS, indexP + 2) || (firstMatch && topDownDFS(s, p, indexS + 1, indexP));
        } else {
            res = firstMatch && topDownDFS(s, p, indexS + 1, indexP + 1);
        }

        memo[indexS][indexP] = res;
        return res;
    }
}
