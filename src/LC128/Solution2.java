package LC128;

import java.util.Map;
import java.util.HashMap;

public class Solution2 {
    public int longestConsecutive(int[] nums) {
        // the length of the consecutive sequence start/end at num
        // N: the length of `nums`
        // time: O(N)
        // space: O(N)
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int num : nums) {
            if (!map.containsKey(num)) {
                int leftLen = map.getOrDefault(num - 1, 0);
                int rightLen = map.getOrDefault(num + 1, 0);
                int len = leftLen + rightLen + 1;
                res = Math.max(res, len);
                map.put(num, len);
                map.put(num - leftLen, len);
                map.put(num + rightLen, len);
            }
        }

        return res;
    }
}
