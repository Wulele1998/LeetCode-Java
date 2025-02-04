package LC1122;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * LC 1122. Relative Sort Array
 */
public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // M: the length of `arr1`
        // N: the length of `arr2`
        // time: O(M + N + M * logM)
        // space: O(N + M + logM)
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> remaining = new ArrayList<>();
        int[] res = new int[arr1.length];

        for (int num : arr2) {
            map.put(num, 0);
        }
        for (int num : arr1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                remaining.add(num);
            }
        }

        int i = 0;
        for (int num : arr2) {
            for (int j = 0; j < map.get(num); j++) {
                res[i++] = num;
            }
        }

        Collections.sort(remaining);
        for (int num : remaining) {
            res[i++] = num;
        }

        return res;
    }
}
