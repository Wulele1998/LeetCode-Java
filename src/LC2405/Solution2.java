package LC2405;

import java.util.Arrays;

/**
 * LC 2405. Optimal Partition of String
 */
public class Solution2 {
    public int partitionString(String s) {
        // time: O(N)
        // space: O(1)
        int[] lastSeen = new int[26];
        int substringStart = 0;
        int res = 1;

        Arrays.fill(lastSeen, -1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (lastSeen[c - 'a'] != -1 && lastSeen[c - 'a'] >= substringStart) {
                res++;
                substringStart = i;
            }
            lastSeen[c - 'a'] = i;
        }

        return res;
    }
}
