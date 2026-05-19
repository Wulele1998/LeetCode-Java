package LC17;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<String> res;
    private String[] digitLetters;
    public List<String> letterCombinations(String digits) {
        digitLetters = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res = new ArrayList<>();

        backtrackHelper(digits, 0, new StringBuilder());

        return res;
    }
    /**
     * @param digits the digits array
     * @param index the index of current digit in digits
     * @param curStr the current string builder stores the string combination
     */
    private void backtrackHelper(String digits, int index, StringBuilder curStr) {
        if (index == digits.length()) {
            res.add(new String(curStr));
            return;
        }

        char curDigit = digits.charAt(index);
        for (char c : digitLetters[curDigit - '0'].toCharArray()) {
            curStr.append(c);
            backtrackHelper(digits, index + 1, curStr);
            // backtrack to its previous status
            curStr.deleteCharAt(curStr.length() - 1);
        }
    }
}
