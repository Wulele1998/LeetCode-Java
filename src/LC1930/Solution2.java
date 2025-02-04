package LC1930;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LC 1930. Unique Length-3 Palindromic Subsequences
 */
public class Solution2 {
    public int countPalindromicSubsequence(String s) {
        // x Y x
        // palindromic string
        // N: the length of `s`
        // time: O(N)
        // space: O(1)
        Map<Character, int[]> map = new HashMap<>();
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), new int[] {i, i});
            } else {
                int[] indices = map.get(s.charAt(i));
                indices[1] = i;
                map.put(s.charAt(i), indices);
            }
        }

        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            int[] indices = entry.getValue();
            Set<Character> set = new HashSet<>();
            for (int j = indices[0] + 1; j < indices[1]; j++) {
                set.add(s.charAt(j));
            }
            res += set.size();
        }

        return res;
    }
}
