package LC455;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // N: the length of `g`
        // M: the length of `s`
        // time: O(N * log N + M * log M)
        // space: O(log N + log M)
        Arrays.sort(g);
        Arrays.sort(s);
        
        int i = 0;
        int j = 0;
        int res = 0;
        
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                res++;
                i++;
                j++;
            } else {
                j++;
            }
        }

        return res;
    }
}