package LC389;

public class Solution {
    public char findTheDifference(String s, String t) {
        // N: the length of `s`
        // time: O(N)
        // space: O(1)

        int[] charS = new int[26];
        int[] charT = new int[26];

        for (char c : s.toCharArray()) {
            charS[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            charT[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (charS[i] < charT[i]) {
                return (char) ('a' + i);
            }
        }

        return ' ';
    }
}