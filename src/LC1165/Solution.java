package LC1165;

public class Solution {
    public int calculateTime(String keyboard, String word) {
        // N: the length of `word`
        // time: O(N)
        // space: O(1)
        int[] letters = new int[26];
        int res = 0;

        for (int i = 0; i < keyboard.length(); i++) {
            letters[keyboard.charAt(i) - 'a'] = i;
        }

        int prev = 0;
        for (char c : word.toCharArray()) {
            res += Math.abs(letters[c - 'a'] - prev);
            prev = letters[c - 'a'];
        }

        return res;

    }
}
