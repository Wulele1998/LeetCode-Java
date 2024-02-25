package LC859;

public class Solution {
    public boolean buddyStrings(String s, String goal) {
        // N: the length of `s`
        // time: O(N)
        // space: O(1)
        int m = s.length();
        int n = goal.length();
        if (m != n)
            return false;

        int count = 0;
        int index = 0;
        byte[] diff = new byte[4];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                count++;
                if (count > 2) {
                    return false;
                }
                diff[index++] = (byte) s.charAt(i);
                diff[index++] = (byte) goal.charAt(i);
            }
        }

        if (count == 0) {
            // if there any repeat char in string
            int[] letter = new int[26];
            for (char c : s.toCharArray()) {
                letter[c - 'a']++;
                if (letter[c - 'a'] > 1) {
                    return true;
                }
            }
            return false;
        }

        return diff[0] == diff[3] && diff[1] == diff[2];
    }
}
