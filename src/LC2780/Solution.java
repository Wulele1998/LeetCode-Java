package LC2780;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minOperations(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(N)
        Map<Integer, Integer> map = new HashMap<>();
        int op = 0;
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            if (val == 1) {
                return -1;
            }
            op += val / 3;
            if (val % 3 != 0)
                op++;
        }

        return op;
    }
}
