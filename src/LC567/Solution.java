package LC567;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // N: the length of `s2`
        // time: O(N)
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        if (check(count)) {
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            count[s2.charAt(i - s1.length()) - 'a']++;
            count[s2.charAt(i) - 'a']--;
            if (check(count)) {
                return true;
            }
        }

        return false;

    }

    private boolean check(int[] count) {
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                return false;
            }
        }

        return true;
    }
}
