package LC3;

import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // slide window
        // N: the length of string `s`
        // time: O(N)
        // space: O(N) => HashSet
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int right = 0;
        int res = 0;

        for (int left = 0; left < n; left++) {
            // move the left pointer 1 step
            if (left != 0) {
                set.remove(s.charAt(left - 1));
            }
            // move the right pointer as for as possible
            while (right < n && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
            }
            // [left, right)
            // open in close, right is open
            res = Math.max(res, right - left);
        }

        return res;
    }
}
