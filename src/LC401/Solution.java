package LC401;

import java.util.ArrayList;
import java.util.List;

/**
 * Feb 16, 2026
 * LC 401. Binary Watch
 */
public class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    res.add(m + ":" + (m < 10 ? "0" + m : m));
                }
            }
        }

        return res;
    }
}
