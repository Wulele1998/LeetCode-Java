package LC791;

import java.util.Arrays;
import java.util.Comparator;

/**
 * LC 791. Custom Sort String
 */
public class Solution2 {
    public String customSortString(String order, String s) {
        // N: the length of `s`
        // time: O(N * logN)
        // space: O(logN)
        int n = s.length();
        Character[] characters = new Character[n];

        for (int i = 0; i < n; i++) {
            characters[i] = s.charAt(i);
        }

        Arrays.sort(characters, (Comparator.comparingInt(order::indexOf)));

        StringBuilder sb = new StringBuilder();
        for (Character c : characters) {
            sb.append(c);
        }

        return sb.toString();
    }
}
