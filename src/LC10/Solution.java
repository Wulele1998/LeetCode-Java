package LC10;

import java.util.Stack;

public class Solution {
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
        memo = new Boolean[m][n]; // True, False, Null 3 state

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
        // base case, the condition to terminate DFS
        if (indexS == m && indexP == n) {
            // both string reach the end => match
            return true;
        }

        if (indexP == n) {
            // one of the string reach the end but another one doesn't => cannot match
            return false;
        }

        if (indexS == m) {
            return isPatternEmpty(p, indexP);
        }

        // check the memo
        if (memo[indexS][indexP] != null) {
            return memo[indexS][indexP]; // avoid repeat calculation
        }

        boolean res = false;
        if (s.charAt(indexS) == p.charAt(indexP) || p.charAt(indexP) == '.') {
            res = topDownDFS(s, p, indexS + 1, indexP + 1);
        } else if (p.charAt(indexP) == '*') {
            // option 1: * matches zero, skip * on p
            res = topDownDFS(s, p, indexS, indexP + 1);
            if (s.charAt(indexS) == p.charAt(indexP - 1) || p.charAt(indexP - 1) == '.')  {
                // match
                boolean oneTimeMatch = topDownDFS(s, p, indexS + 1, indexP + 1);
                boolean multTimeMatch = topDownDFS(s, p, indexS + 1, indexP);
                res = res || oneTimeMatch || multTimeMatch;
            }
        }

        if (indexP + 1 < n && p.charAt(indexP + 1) == '*') {
            // s.charAt(indexS) != p.charAt(indexP) && p.charAt(indexP) != '.' && p.charAt(indexP) != '*'
            // skip indexP, indexP + 1
            res = res || topDownDFS(s, p, indexS, indexP + 2);
        }

        memo[indexS][indexP] = res;
        return res;
    }

    private boolean isPatternEmpty(String p, int index) {
        Stack<Character> stack = new Stack<>();
        for (int i = index; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                if (!stack.isEmpty()) {
                    return false;
                }
                stack.push(p.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}
