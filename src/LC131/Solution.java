package LC131;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // N: the length of string s
    // time: O(N * 2 ^ N)
    private List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();

        backtrackHelper(s, 0, new ArrayList<>());

        return res;
    }

    /**
     * backtrack helper recursion function
     * @param s string s
     * @param index the index of current recursion function, we will do substring split in substring [index:]
     * @param curList the current string list that stores current substring partitioning
     */
    private void backtrackHelper(String s, int index, List<String> curList) {
        // base case: index reaches the end of string s, we found the qualified list of substring
        if (s.length() == index) {
            res.add(new ArrayList<>(curList));
            return;
        }

        // find the next palindrome substring start from index
        for (int r = index; r < s.length(); r++) {
            // current substring: s.substring(index, r + 1)
            if (isPalindrome(s, index, r)) {
                curList.add(s.substring(index, r + 1));
                // move to the rest part
                backtrackHelper(s, r + 1, curList);
                // backtrack to previous state, for next loop
                curList.removeLast();
            }
        }
    }

    /**
     * whether the substring s.substring(indexL, indexR + 1) is palindrome
     * @param s string s
     * @param indexL the left of index range of the substring
     * @param indexR the right of index range of the substring
     * @return true / false
     */
    private boolean isPalindrome(String s, int indexL, int indexR) {
        while (indexL <= indexR) {
            if (s.charAt(indexL) != s.charAt(indexR)) {
                return false;
            }
            indexL++;
            indexR--;
        }

        return true;
    }
}
