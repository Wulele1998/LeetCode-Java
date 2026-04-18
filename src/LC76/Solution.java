package LC76;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m < n) { // edge case
            return "";
        }

        Map<Character, Integer> freqMapS = new HashMap<>();
        Map<Character, Integer> freqMapT = new HashMap<>();
        for (char c : t.toCharArray()) {
            freqMapT.put(c, freqMapT.getOrDefault(c, 0) + 1);
        }

        int minWindowSize = m + 1;
        String res = "";
        int count = 0; // use to count how many characters in the substring window has matched string t
        int l = 0;
        for (int r = 0; r < m; r++) {
            char c = s.charAt(r);
            freqMapS.put(c, freqMapS.getOrDefault(c, 0) + 1);
            if (freqMapT.containsKey(c) && freqMapT.get(c).equals(freqMapS.get(c))) {
                count++;
            }

            // when substring [l, r] is a valid window, now we shrink the window by moving the l pointer right
            while (count == freqMapT.size()) {
                if (r - l + 1 < minWindowSize) {
                    minWindowSize = r - l + 1;
                    res = s.substring(l, r + 1);
                }
                // remove the character at l
                char leftChar = s.charAt(l);
                freqMapS.put(leftChar, freqMapS.get(leftChar) - 1);
                if (freqMapT.containsKey(leftChar) && freqMapT.get(leftChar) > freqMapS.get(leftChar)) {
                    count--;
                }
                l++;
            }
        }

        return res;
    }
}
