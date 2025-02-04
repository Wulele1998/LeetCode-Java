package LC139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution4 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Dynamic Programming
        // N: the length of `s`
        // time: O(N ^ 2)
        // space: O(N)
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    // s.substring[0, i] can be consisted by the dict
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
