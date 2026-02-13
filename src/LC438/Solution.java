package LC438;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 438. Find All Anagrams in a String
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // M: the length of `p`
        // N: the length of `s`
        // time: O(M + N)
        // space: O(N)
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }

        int[] letterS = new int[26];
        int[] letterP = new int[26];

        for (char c : p.toCharArray()) {
            letterP[c - 'a']++;
        }

        // [0, len(s) - len(p)]
        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (i == 0) {
                // init the window
                for (int j = 0; j < p.length(); j++) {
                    letterS[s.charAt(j) - 'a']++;
                }
            } else {
                // move the window
                letterS[s.charAt(i - 1) - 'a']--;
                // [i, i + len(p) - 1]
                letterS[s.charAt(i + p.length() - 1) - 'a']++;
            }

            if (arrayEquals(letterS, letterP)) {
                res.add(i);
            }
        }

        return res;
    }

    private boolean arrayEquals(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }
}
