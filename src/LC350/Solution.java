package LC350;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * LC 350. Intersection of Two Arrays II
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // M: the size of `nums1`
        // N: the size of `nums2`
        // time: O(M + N)
        // space: O(M + N)

        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())) {
                for (int i = 0; i < Math.min(map2.get(entry.getKey()), entry.getValue()); i++) {
                    list.add(entry.getKey());
                }
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
