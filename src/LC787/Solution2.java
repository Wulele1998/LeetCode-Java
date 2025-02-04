package LC787;

import java.util.Arrays;

/**
 * LC 787. Cheapest Flights Within K Stops
 */
public class Solution2 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Bellman Ford
        // N: the number of cities
        // E: the number of flights
        // time: O((N + E) * K)
        // space: O(N)
        
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[src] = 0;
        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(res, n);
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int dis = flight[2];
                // relex operation
                if (res[from] != Integer.MAX_VALUE) {
                    temp[to] = Math.min(temp[to], res[from] + dis);
                }
            }

            res = temp;
        }

        return res[dst] == Integer.MAX_VALUE ? -1 : res[dst];
    }
}
