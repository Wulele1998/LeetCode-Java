package LC3043;

import java.util.HashSet;
import java.util.Set;

/**
 * LC 3043. Find the Length of the Longest Common Prefix
 */
public class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        // N: the length of `arr1`
        // M: the length of `arr1`
        // time: O(M + N)
        // space: O(N)

        // use HashSet
        Set<Integer> set = new HashSet<>();

        for (int num : arr1) {
            String s = String.valueOf(num);
            for (int i = 0; i < s.length(); i++) {
                set.add(Integer.parseInt(s.substring(0, i + 1)));
            }
        }

        int res = 0;
        for (int num : arr2) {
            String s = String.valueOf(num);
            for (int i = res; i < s.length(); i++) {
                if (set.contains(Integer.parseInt(s.substring(0, i + 1)))) {
                    res = i + 1;
                }
            }
        }

        return res;
    }
}
