package LC2559;

import java.util.HashSet;
import java.util.Set;

/**
 * LC 2559. Count Vowel Strings in Ranges
 */
public class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        // prefix sum
        // N: the length of `words`
        // M: the length of `queries`
        // time: O(M + N)
        // space: O(M)
        int n = words.length;
        Set<Character> vowel = new HashSet<>();
        int[] prefixSum = new int[n + 1];
        int[] res = new int[queries.length];
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');


        for (int i = 0; i < n; i++) {
            String s = words[i];
            if (vowel.contains(s.charAt(0)) && vowel.contains(s.charAt(s.length() - 1))) {
                prefixSum[i + 1] = prefixSum[i] + 1;
            } else {
                prefixSum[i + 1] = prefixSum[i];
            }
        }

        for (int i = 0; i < queries.length; i++) {
            res[i] = prefixSum[queries[i][1] + 1] - prefixSum[queries[i][0]];
        }

        return res;
    }
}
