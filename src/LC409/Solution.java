package LC409;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 409. Longest Palindrome
 */
public class Solution {
    public int longestPalindrome(String s) {
        // N: the length of `s`
        // time: O(N)
        // space: O(1)
        HashMap<Character, Integer> map = new HashMap<>();
        boolean oddFlag = false;
        int res = 0;

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                res += entry.getValue();
            } else {
                res += entry.getValue() - 1;
                oddFlag = true;
            }
        }

        return oddFlag ? res + 1 : res;
    }
}
