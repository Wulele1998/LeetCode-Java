package LC2900;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        // Greedy
        // time: O(N)
        // space: O(1), no extra space needed except the return list
        List<String> res = new ArrayList<>();
        int n = groups.length;

        for (int i = 0; i < n; i++) {
            if (i == 0 || groups[i] != groups[i - 1]) {
                res.add(words[i]);
            }
        }

        return res;
    }
}
