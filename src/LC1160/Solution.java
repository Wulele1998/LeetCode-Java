package LC1160;

public class Solution {
    public int countCharacters(String[] words, String chars) {
        // M: the length of `words`
        // N: the length of `chars`
        // K: the average length of each word
        // time: O(M * K + N)
        // space: O(1), constant for 26
        int[] letters = new int[26];
        int res = 0;

        for (char c : chars.toCharArray()) {
            letters[c - 'a']++;
        }

        for (String word : words) {
            int[] wordLetters = new int[26];
            boolean flag = true;
            for (char c : word.toCharArray()) {
                if (letters[c - 'a'] == 0) {
                    flag = false;
                    break;
                }
                wordLetters[c - 'a']++;
                if (wordLetters[c - 'a'] > letters[c - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res += word.length();
            }
        }

        return res;
    }
}
