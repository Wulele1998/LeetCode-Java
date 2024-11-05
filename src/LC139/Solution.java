package LC139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // brute force
        // recursion
        // N: the length of `s`
        // time: O(2 ^ N)
        // space: O(N) => recursive stack
        return helper(s, new HashSet<>(wordDict), 0);
    }

    private boolean helper(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }

        for (int end = start + 1; end < s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && helper(s, wordDict, end)) {
                return true;
            }
        }

        return false;
    }
}
