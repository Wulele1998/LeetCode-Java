package LC791;

import java.util.HashMap;

/**
 * LC 791. Custom Sort String
 */
public class Solution3 {
    public String customSortString(String order, String s) {
        // N: the length of `s`
        // time: O(N)
        // space: O(N)
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            if (freq.containsKey(c)) {
                int repeat = freq.getOrDefault(c, 0);
                sb.append(String.valueOf(c).repeat(repeat));
                freq.remove(c);
            }
        }

        for (char c : freq.keySet()) {
            int repeat = freq.get(c);
            sb.append(String.valueOf(c).repeat(repeat));
        }

        return sb.toString();
    }
}
