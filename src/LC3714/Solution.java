package LC3714;

import java.util.HashMap;
import java.util.Map;

/**
 * Feb 13, 2026
 * LC 3714. Longest Balanced Substring II
 */
public class Solution {
    public int longestBalanced(String s) {
        // N: the length of `s`
        // time: O(N)
        // space: O(N)
        int n = s.length();
        int res = 0;
        int[][] prefixCount = new int[n + 1][3];
        final long BASE1 = 100_000L;
        final long BASE2 = 10_000_000_000L;
        final String[] pattern = {"abc", "ab", "ac", "bc", "a", "b", "c"};

        for (int i = 0; i < n; i++) {
            prefixCount[i + 1][0] = prefixCount[i][0];
            prefixCount[i + 1][1] = prefixCount[i][1];
            prefixCount[i + 1][2] = prefixCount[i][2];
            prefixCount[i + 1][s.charAt(i) - 'a']++;
        }

        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            int a = prefixCount[i][0];
            int b = prefixCount[i][1];
            int c = prefixCount[i][2];

            for (int p = 0; p < pattern.length; p++) {
                long key = BASE2 * p;
                key = switch (pattern[p]) {
                    case "abc" -> (a - b) + (b - c) * BASE1;
                    case "ab" -> c + (a - b) * BASE1;
                    case "ac" -> b + (a - c) * BASE1;
                    case "bc" -> a + (b - c) * BASE1;
                    case "a" -> b + c * BASE1;
                    case "b" -> a + c * BASE1;
                    case "c" -> a + b * BASE1;
                    default -> key;
                };

                if (map.containsKey(key)) {
                    res = Math.max(res, i - map.get(key));
                } else {
                    map.put(key, i);
                }
            }
        }

        return res;
    }
}
