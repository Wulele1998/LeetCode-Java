package LC401;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        // 10 bit, [0, 1024)
        for (int i = 0; i < 1024; i++) {
            // left 4 bit => hour
            // right 6 bit => minute
            int hour = i >> 6;
            // extract lower 6 bits: i & 111111
            int minute = i & (64 - 1);
            if (hour < 12 && minute < 60 && Integer.bitCount(i) == turnedOn) {
                res.add(hour + ":" + (minute < 10 ? "0" : "") + minute);
            }
        }

        return res;
    }
}
