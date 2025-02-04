package LC791;

import java.util.Arrays;
import java.util.HashMap;

/**
 * LC 791. Custom Sort String
 */
public class Solution {
    public String customSortString(String order, String s) {
        // N: the length of `s`
        // time: O(N * logN)
        // space: O(logN)
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        Character[] tempChars = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            tempChars[i] = s.charAt(i);
        }

        Arrays.sort(tempChars, (o1, o2) -> {
            int value1 = map.getOrDefault(o1, -1);
            int value2 = map.getOrDefault(o2, -1);

            return value1 - value2;
        });

        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = tempChars[i];
        }

        return String.valueOf(chars);
    }
}
