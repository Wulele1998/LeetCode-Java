package LC205;

import java.util.HashMap;

/**
 * LC 205. Isomorphic Strings
 */
public class Solution {
    // N: the length of `s`
    // time: O(N)
    // space: O(N), StringBuilder
    public boolean isIsomorphic(String s, String t) {
        return transfer(s).equals(transfer(t));
    }

    private String transfer(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                // save the index of first-time appearance
                map.put(s.charAt(i), i);
            }
            sb.append(map.get(s.charAt(i)));
            sb.append(" ");
        }

        return sb.toString();
    }
}
