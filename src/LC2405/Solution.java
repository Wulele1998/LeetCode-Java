package LC2405;

import java.util.Arrays;

/**
 * LC 2405. Optimal Partition of String
 */
public class Solution {
    public int partitionString(String s) {
        // time: O(N)
        // space: O(1)
        int[] count = new int[26];
        int res = 1;

        for (char c : s.toCharArray()){
            if (count[c - 'a'] != 0) {
                res++;
                // reset the count array
                Arrays.fill(count, 0);
            }

            count[c - 'a']++;
        }

        return res;
    }
}
