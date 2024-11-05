package LC3016;

import java.util.Arrays;

/**
 * LC 3016. Minimum Number of Pushes to Type Word II
 */
public class Solution {
    public int minimumPushes(String word) {
        // N: the length of `word`
        // time: O(N)
        // space: O(1)
        int[] lettersCount = new int[26];
        int res = 0;

        for (char c : word.toCharArray()) {
            lettersCount[c - 'a']++;
        }

        Arrays.sort(lettersCount);

        for (int i = 25; i >= 0; i--) {
            int rank = 26 - i;
            if (rank % 8 == 0)
                res += rank / 8 * lettersCount[i];
            else
                res += (rank / 8 + 1) * lettersCount[i];
        }

        return res;
    }
}
