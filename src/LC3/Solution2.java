package LC3;

import java.util.HashMap;

public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        // N: the length of `s`
        // time: O(N)
        // space: O(N)
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int res = 0;

        for (int left = 0, right = 0; right < n; right++) {
            // move right 1 step each time
            if (map.containsKey(s.charAt(right))) {
                // if map contains the character
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            // [left, right]
            res = Math.max(res, right - left + 1);
            map.put(s.charAt(right), right);
        }

        return res;
    }
}
