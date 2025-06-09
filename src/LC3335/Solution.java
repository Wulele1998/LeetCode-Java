package LC3335;

/**
 * LC 3335. Total Characters in String After Transformations I
 */
public class Solution {
    public int lengthAfterTransformations(String s, int t) {
        // N: t
        // time: O(N)
        // space: O(1)
        int[] letters = new int[26];
        int n = s.length();
        final int MOD = 1_000_000_007;
        for (char c : s.toCharArray()) {
            letters[c - 'a']++;
        }

        for (int i = 0; i < t; i++) {
            int numZ = letters[25];
            n = (n + numZ)  % MOD;
            for (int j = 25; j >= 1; j--) {
                letters[j] = letters[j - 1];
            }
            letters[0] = numZ;
            letters[1] = (letters[1] + numZ) % MOD;
        }

        return n;
    }
}
