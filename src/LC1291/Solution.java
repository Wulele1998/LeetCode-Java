package LC1291;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        // slide window
        // time: O(1)
        // space: O(1)
        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();
        List<Integer> res = new ArrayList<>();
        String base = "123456789";

        for (int window = lowLen; window <= highLen; window++) {
            for (int i = 0; i <= 9 - window; i++) {
                String numStr = base.substring(i, i + window);
                int num = Integer.parseInt(numStr);
                if (num >= low && num <= high)
                    res.add(num);
            }
        }

        return res;
    }
}
