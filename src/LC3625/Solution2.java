package LC3625;

import java.util.HashMap;

/**
 * Doc 3, 2025
 * LC 3625. Count Number of Trapezoids II
 */
public class Solution2 {
    public int countTrapezoids(int[][] points) {
        // N: the length of `points`
        // time: O(N ^ 2)
        // space: O(N ^ 2)
        int n = points.length;
        HashMap<Integer, HashMap<Integer, Integer>> segments = new HashMap<>();
        HashMap<Integer, HashMap<Integer, Integer>> parallelSegments = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dx = x2 - x1;
                int dy = y2 - y1;
                if (dx < 0 || (dy < 0 && dx == 0)) {
                    dx = -dx;
                    dy = -dy;
                }
                int gcd = findGCD(dx, dy);
                int slopeX = dx / gcd;
                int slopeY = dy / gcd;
                int lineParam = slopeX * y1 - slopeY * x1;

                int keyNormalized = (slopeX << 12) | (slopeY + 2000);
                int keyFull = (dx << 12) | (dy + 2000); // use for parallelograms

                segments.computeIfAbsent(keyNormalized, k -> new HashMap<>())
                        .put(lineParam, segments.get(keyNormalized).getOrDefault(lineParam, 0) + 1);
                parallelSegments.computeIfAbsent(keyFull, k -> new HashMap<>())
                        .put(lineParam, parallelSegments.get(keyFull).getOrDefault(lineParam, 0) + 1);
            }
        }

        return calculatePairs(segments) - calculatePairs(parallelSegments) / 2;

    }

    private int calculatePairs(HashMap<Integer, HashMap<Integer, Integer>> map) {
        int res = 0;
        for (HashMap<Integer, Integer> innerMap : map.values()) {
            int sum = 0;
            for (int value : innerMap.values()) {
                res += sum * value;
                sum += value;
            }
        }

        return res;
    }

    // find the greatest common divisor
    private int findGCD(int a, int b) {
        if (a == 0) {
            return b;
        }
        return findGCD(b % a, a);
    }
}
