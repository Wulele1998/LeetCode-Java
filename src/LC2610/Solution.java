package LC2610;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(N)
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        int maxOccur = 0;  // the max number of occurrence

        for (int num : nums) {
            int occur = map.getOrDefault(num, 0) + 1;
            map.put(num, occur);
            maxOccur = Math.max(maxOccur, occur);
        }

        for (int i = 0; i < maxOccur; i++) {
            res.add(new ArrayList<>());
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                res.get(i).add(entry.getKey());
            }
        }

        return res;
    }
}
