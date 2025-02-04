package LC340;

import java.util.HashMap;

/**
 * LC 340. Longest Substring with At Most K Distinct Characters
 */
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // sliding window
        // N: the length of `s`
        // time: O(N)
        // space: O(1), 26 letters totally
        int res = 0;
        int i = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int j = 0; j < s.length(); j++) {
            char addChar = s.charAt(j);
            map.put(addChar, map.getOrDefault(addChar, 0) + 1);
            while (map.size() > k) {
                char removeChar = s.charAt(i);
                map.put(removeChar, map.get(removeChar) - 1);
                if (map.get(removeChar) == 0)
                    map.remove(removeChar);
                i++;
            }
            res = Math.max(res, j - i + 1);
        }

        return res;
    }
}
