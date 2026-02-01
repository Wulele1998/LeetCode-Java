package LC2976;

import java.util.Arrays;

/**
 * Jan 29, 2026
 * LC 2976. Minimum Cost to Convert String I
 */
public class Solution2 {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        // V: the number of vertices
        // time: O(V ^ 3)
        // space: O(V ^ 2)
        long[][] minCost = new long[26][26];
        final int INF = Integer.MAX_VALUE;
        // initialize 
        for (int i = 0; i < 26; i++) { 
            Arrays.fill(minCost[i], INF);
            minCost[i][i] = 0L;
        }

        for (int i = 0; i < cost.length; i++) {
            int startIndex = original[i] - 'a';
            int endIndex = changed[i] - 'a';
            minCost[startIndex][endIndex] = Math.min(cost[i], minCost[startIndex][endIndex]);
        }
        

        // Floyd algorithm
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (minCost[i][k] != INF && minCost[k][j] != INF) {
                        if (minCost[i][j] > minCost[i][k] + minCost[k][j]) {
                            minCost[i][j] = minCost[i][k] + minCost[k][j];
                        }
                    }
                }
            }
        }

        long totalCost = 0L;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)) {
                int srcIndex = source.charAt(i) - 'a';
                int tagIndex = target.charAt(i) - 'a';
                if (minCost[srcIndex][tagIndex] != INF) {
                    totalCost += minCost[srcIndex][tagIndex];
                } else {
                    return -1;
                }
            }
        }

        return totalCost;
    }
}
