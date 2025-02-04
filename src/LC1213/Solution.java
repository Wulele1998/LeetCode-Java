package LC1213;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        // HashMap
        // N: the maximum length of three arrays
        // time: O(N)
        // space: O(N)
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : arr2) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : arr3) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 3) {
                res.add(entry.getKey());
            }
        }

        return res;
    }
}
