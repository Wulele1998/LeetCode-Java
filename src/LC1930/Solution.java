package LC1930;

import java.util.*;

/**
 * LC 1930. Unique Length-3 Palindromic Subsequences
 */
public class Solution {
    public int countPalindromicSubsequence(String s) {
        // x Y x
        // palindromic string
        // N: the length of `s`
        // time: O(N)
        // space: O(1)
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            }
        }
        int count = map.size();

        for (int i = s.length() - 1; i >= 0 && count > 0; i--) {
            if (map.containsKey(s.charAt(i))) {
                int start = map.get(s.charAt(i));
                Set<Character> set = new HashSet<>();
                for (int j = start + 1; j < i; j++) {
                    set.add(s.charAt(j));
                }
                res += set.size();
                map.remove(s.charAt(i));
                count--;
            }
        }

        return res;
    }
}
