package LC3337;

import java.util.List;

/**
 * LC 3337. Total Characters in String After Transformations II
 */

public class Solution {
    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        // Time limit exceed
        int[] letters = new int[26];
        for (char c : s.toCharArray()) {
            letters[c - 'a']++;
        }

        int len = s.length();
        final int MOD = 1_000_000_000 + 7;
        int[] nextLetters;
        for (int i = 0; i < t; i++) {
            nextLetters = new int[26];
            for (int j = 0; j < 26; j++) {
                long next = nums.get(j);
                for (int k = j + 1; k <= j + next; k++) {
                    nextLetters[k % 26] = (nextLetters[k % 26] + letters[j]) % MOD;
                }
                len = (len + (int) ((next - 1) * letters[j] % MOD)) % MOD;
            }

            letters = nextLetters;
        }

        return len;
    }
}
