package LC2147;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int numberOfWays(String corridor) {
        // N: the length of 'corridor'
        // time: O(N)
        // space: O(N)
        final int MOD = 1_000_000_007;
        int n = corridor.length();
        int count = 0;
        char[] chars = corridor.toCharArray();
        List<Integer> seatIndexList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (chars[i] == 'S') {
                count++;
                seatIndexList.add(i);
            }
        }

        
        if (count == 0 || count % 2 != 0) {
            return 0;
        }

        long res = 1L;
        int prev = seatIndexList.get(1);
        for (int i = 2; i < seatIndexList.size(); i += 2) {
            res = res * (seatIndexList.get(i) - prev) % MOD;
            prev = seatIndexList.get(i + 1); 
        }

        return (int)res;
    }
}
