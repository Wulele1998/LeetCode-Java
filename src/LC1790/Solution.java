package LC1790;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 1790. Check if One String Swap Can Make Strings Equal
 */
public class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        // N: the length of two strings
        // time: O(N)
        // space: O(1)
        int m = s1.length();
        int n = s2.length();
        if (m != n) {
            return false;
        }
        List<Character> list = new ArrayList<>();
        int countDiff = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                countDiff++;
                if (countDiff > 2) {
                    return false;
                }
                list.add(s1.charAt(i));
                list.add(s2.charAt(i));
            }
        }

        return countDiff == 0 || (countDiff == 2 && list.get(0) == list.get(3) && list.get(1) == list.get(2));
    }
}
