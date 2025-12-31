package LC3623;

import java.util.HashMap;
import java.util.Map;

/**
 * Dec 2, 2025
 * LC 3623. Count Number of Trapezoids I
 */
public class Solution {
    public int countTrapezoids(int[][] points) {
        // N: the number of `points`
        // time: O(N)
        // space: O(N)
        final int MOD = 1_000_000_007;
        long res = 0L;
        long existingPairs = 0L;
        // key: y-axis value
        // val: the number of point in that y-axis
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] point : points) {
            map.put(point[1], map.getOrDefault(point[1], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int pointNumber = entry.getValue();
            long edgeNum = (long) pointNumber * (pointNumber - 1) / 2 % MOD;
            res = (res + edgeNum * existingPairs) % MOD;
            existingPairs = (existingPairs + edgeNum) % MOD;
        }

        return (int) res;
    }
}
