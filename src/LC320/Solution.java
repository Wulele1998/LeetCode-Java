package LC320;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 320. Generalized Abbreviation
 */
public class Solution {
    // backtrack
    List<String> res;
    public List<String> generateAbbreviations(String word) {
        // N: the length of `word`
        // time: O(2 ^ N)
        // space: O(N), stack space
        res = new ArrayList<>();
        backtrackHelper(word, new StringBuilder(), 0, 0);

        return res;
    }

    private void backtrackHelper(String word, StringBuilder current, int index, int count) {
        if (index == word.length()) {
            if (count > 0) {
                current.append(count);
            }
            res.add(current.toString());
            return;
        }
        int length = current.length();
        // option 1: keep current character
        if (count > 0) {
            current.append(count);
        }

        current.append(word.charAt(index));
        backtrackHelper(word, current, index + 1, 0);
        // backtrack
        while (current.length() > length) {
            current.deleteCharAt(current.length() - 1);
        }

        // option 2: abbreviate the character
        backtrackHelper(word, current, index + 1, count + 1);
    }
}
