package LC1897;

public class Solution {
    public boolean makeEqual(String[] words) {
        // N: the length of `words`
        // M: the average length of each word
        // time: O(N * M)
        // space: O(1)
        int n = words.length;
        int[] letters = new int[26];

        if (n == 1)
            return true;

        for (String word : words) {
            for (char c : word.toCharArray()) {
                letters[c - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (letters[i] % n != 0)
                return false;
        }

        return true;
    }
}
