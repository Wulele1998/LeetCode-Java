package LC696;

import java.util.List;
import java.util.ArrayList;

/**
 * Feb 19, 2026
 * LC 696. Count Binary Substrings
 */
public class Solution {
    public int countBinarySubstrings(String s) {
        // N: the length of `s`
        // time: O(N)
        // space: O(N)
        List<Integer> bits = new ArrayList<>();
        int count = 1;
        int res = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                bits.add(count);
                count = 1;
            }
        }
        bits.add(count);

        for (int i = 0; i < bits.size() - 1; i++) {
            res += Math.min(bits.get(i), bits.get(i + 1));
        }

        return res;
    }
}
