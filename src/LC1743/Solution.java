package LC1743;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        // N: the length of `adjacentPairs`
        // time complexity: O(N)
        // space complexity: O(N)
        Map<Integer, int[]> map = new HashMap<>();
        int n = adjacentPairs.length + 1;

        for (int[] pair : adjacentPairs) {
            if (map.containsKey(pair[0])) {
                map.get(pair[0])[1] = pair[1];
            } else {
                map.put(pair[0], new int[] {pair[1], -100001});
            }

            if (map.containsKey(pair[1])) {
                map.get(pair[1])[1] = pair[0];
            } else {
                map.put(pair[1], new int[] {pair[0], -100001});
            }
        }

        int[] res = new int[n];
        // find the start number
        int start = -100001;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            if (entry.getValue()[1] == -100001) {
                start = entry.getKey();
            }
        }

        int index = 0;
        res[index++] = start;
        int prev = -100001;
        int cur = start;
        while (index < n) {
            int[] adj = map.get(cur);
            res[index] = prev == adj[0] ? adj[1] : adj[0];
            prev = cur;
            cur = res[index];
            index++;
        }

        return res;
    }
}
