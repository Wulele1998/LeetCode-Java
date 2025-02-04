package LC2955;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 2955. Number of Same-End Substrings
 */
public class Solution {
    public int[] sameEndSubstringCount(String s, int[][] queries) {
        // Time limited exceed
        int n = queries.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = sameEndString(s.substring(queries[i][0], queries[i][1] + 1));
        }

        return res;
    }

    private int sameEndString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int res = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            res += entry.getValue() * (entry.getValue() + 1) / 2;
        }

        return res;
    }
}
