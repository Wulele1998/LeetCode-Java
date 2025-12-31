package LC3625;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Doc 3, 2025
 * LC 3625. Count Number of Trapezoids II
 */
public class Solution {
    public int countTrapezoids(int[][] points) {
        // N: the length of `points`
        // time: O(N ^ 2)
        // space: O(N ^ 2)
        int n = points.length;
        final double INF = 1e9 + 7;
        Map<Double, List<Double>> slopeToIntercept = new HashMap<>();
        Map<Integer, List<Double>> midToSlope = new HashMap<>();
        int res = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dx = x2 - x1;
                int dy = y2 - y1;

                // y = k * x + b
                // k = (y2 - y1) / (x2 - x1)


                double k;
                double b;

                if (x1 == x2) {
                    // k is infinity
                    k = INF;
                    b = x1;
                } else {
                    k = 1.0 * dy / dx;
                    b = 1.0 * (y1 * dx - dy * x1) / dx;
                }

                if (k == -0.0) {
                    k = 0.0;
                }
                if (b == -0.0) {
                    b = 0.0;
                }

                int mid = (x1 + x2) * 10000 + (y1 + y2);
                slopeToIntercept.computeIfAbsent(k, key -> new ArrayList<>()).add(b);
                midToSlope.computeIfAbsent(mid, key -> new ArrayList<>()).add(k);
            }
        }

        for (List<Double> intercepts : slopeToIntercept.values()) {
            if (intercepts.size() == 1) {
                continue; // we need at least 2 to form Trapezoid
            }
            Map<Double, Integer> countMap = new HashMap<>();
            for (double intercept : intercepts) {
                countMap.put(intercept, countMap.getOrDefault(intercept, 0) + 1);
            }
            int sum = 0;
            for (int count : countMap.values()) {
                res += sum * count;
                sum += count;
            }
        }

        for (List<Double> slopes : midToSlope.values()) {
            if (slopes.size() == 1) {
                continue;
            }
            Map<Double, Integer> countMap = new HashMap<>();
            for (double slop : slopes) {
                countMap.put(slop, countMap.getOrDefault(slop, 0) + 1);
            }
            int sum = 0;
            for (int count : countMap.values()) {
                res -= sum * count;
                sum += count;
            }
        }

        return res;
    }
}
