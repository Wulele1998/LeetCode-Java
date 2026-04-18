package LC424;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int l = 0;
        int res = 0;
        int maxFreq = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(c)); // update the maxFreq
            // current substring [l, r]
            while (r - l + 1 > maxFreq + k) {
                // we need move l pointer
                freqMap.put(s.charAt(l), freqMap.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
