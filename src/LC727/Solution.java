package LC727;

public class Solution {
    // M: the length of `s1`
    // N: the length of `s2`
    // time: O(M * M)
    // space: O(1)
    public String minWindow(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        // edge case
        if (m < n) {
            return "";
        }
        int minWindowSize = m + 1;
        int startIndex = -1;
        for (int i = 0; i < m; i++) {
            if (s1.charAt(i) == s2.charAt(0)) {
                int len = substringLength(s1, s2, i);
                if (len != -1 && len < minWindowSize) {
                    minWindowSize = len;
                    startIndex = i;
                }
            }
        }

        return startIndex == -1 ? "" : s1.substring(startIndex, startIndex + minWindowSize);
    }

    private int substringLength(String s1, String s2, int index) {
        int i = index;
        int j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
            }
            i++;
        }
        if (j == s2.length()) {
            // s1.substring(index, i) includes s2 as substring
            return i - index;
        } else {
            return -1; // cannot find the substring
        }

    }
}
