package LC788;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Integer, Integer> map;
    public int rotatedDigits(int n) {
        // time: O(N)
        // space: O(1)
        map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 5);
        map.put(5, 2);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);

        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (isGoodNumber(i)) {
                res++;
            }
        }

        return res;
    }

    private boolean isGoodNumber(int n) {
        int rotate = 0;
        int base = 1;
        int num = n;
        while (n > 0) {
            int digit = n % 10;
            if (!map.containsKey(digit)) {
                return false;
            }
            rotate += base * map.get(digit);
            base *= 10;
            n /= 10;
        }

        return rotate != num;
    }
}
