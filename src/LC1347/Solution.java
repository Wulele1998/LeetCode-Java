package LC1347;

public class Solution {
    public int minSteps(String s, String t) {
        // N: the length of `s`
        // time: O(N)
        // space: O(1)
        int[] letterS = new int[26];
        int[] letterT = new int[26];
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            letterS[s.charAt(i) - 'a']++;
            letterT[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            count += Math.abs(letterT[i] - letterS[i]);
        }

        return count / 2;
    }
}
