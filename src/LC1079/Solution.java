package LC1079;

import java.util.HashSet;

public class Solution {
    // brute force
    // time: O(N! * N)
    // space: O(N! * N) Factorial N
    HashSet<String> set = new HashSet<>();
    public int numTilePossibilities(String tiles) {
        int[] alphabet = new int[26];
        for (char c : tiles.toCharArray()) {
            alphabet[c - 'A']++;
        }
        StringBuilder sb = new StringBuilder();
        recursion(tiles.toCharArray(), sb, alphabet);

        return set.size();
    }

    private void recursion(char[] tiles,StringBuilder sb, int[] alphabet) {
        set.add(sb.toString());
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] > 0) {
                sb.append((char) (i + 'A'));
                alphabet[i]--;
                recursion(tiles, sb, alphabet);
                // do backtrack
                alphabet[i]++;
            }
        }
    }
}
