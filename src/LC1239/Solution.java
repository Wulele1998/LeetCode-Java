package LC1239;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
public class Solution {
    public int maxLength(List<String> arr) {
        // brute force
        // N: the length of `arr`
        // time: O(2 ^ N)
        // space: O(2 ^ N)
        List<String> results = new ArrayList<>();
        results.add("");
        int best = 0;

        for (String word : arr) {
            for (int i = 0; i < results.size(); i++) {
                String afterConcat = results.get(i) + word;
                Set<Character> set = new HashSet<>();
                for (char c : afterConcat.toCharArray())
                    set.add(c);
                if (set.size() == afterConcat.length()) {
                    results.add(afterConcat);
                    best = Math.max(best, afterConcat.length());
                }
            }
        }

        return best;
    }
}
