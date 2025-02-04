package LC624;

import java.util.List;

/**
 * LC 624. Maximum Distance in Arrays
 */
public class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        // N: the length of arrays
        // time: O(N)
        // space: O(1)
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int min = arrays.get(0).get(0);
        int res = 0;

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            int n = array.size();
            int currentMax = array.get(n - 1);
            int currentMin = array.get(0);
            res = Math.max(res, Math.max(Math.abs(currentMax - min), Math.abs(max - currentMin)));

            max = Math.max(max, currentMax);
            min = Math.min(min, currentMin);
        }

        return res;
    }
}
