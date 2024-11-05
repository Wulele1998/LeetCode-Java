package LC387;

public class Solution {
    public int firstUniqChar(String s) {
        // N: the length of `s`
        // time: O(N)
        // space: O(1)
        int[] letters = new int[26];
        for (char c : s.toCharArray()) {
            letters[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (letters[s.charAt(i) - 'a'] == 1)
                return i;
        }

        return -1;
    }
}
