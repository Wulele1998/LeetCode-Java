package LC139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // N: the length of `s`
        // time: O(N ^ 2)
        // space: O(N) => stack and memo
        return helperMemo(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    private boolean helperMemo(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        // the default value of Boolean[] is null
        // avoid repeat calculation
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && helperMemo(s, wordDict, end, memo)) {
                memo[start] = true;
                return true;
            }
        }

        memo[start] = false;
        return false;
    }
}
