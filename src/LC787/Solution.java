package LC787;

import java.util.*;

/**
 * LC 787. Cheapest Flights Within K Stops
 */
public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // BFS
        // N: the number of cities
        // E: the number of flights
        // time: O(N + E * K)
        // space: O(N + E * K)

        Map<Integer, List<int[]>> graph = new HashMap<>();
        Queue<int[]> queue = new LinkedList<>();
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int dis = flight[2];
            graph.computeIfAbsent(from, key -> new ArrayList<>()).add(new int[] { to, dis });
        }
        
        queue.add(new int[] { src, 0 });

        while (!queue.isEmpty() && k >= 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] adj : graph.getOrDefault(cur[0], new ArrayList<>())) {
                    if (cur[1] + adj[1] < res[adj[0]]) {
                        queue.add(new int[] { adj[0], cur[1] + adj[1] });
                        res[adj[0]] = cur[1] + adj[1];
                    }
                }
            }
            k--;
        }

        return res[dst] == Integer.MAX_VALUE ? -1 : res[dst];
    }
}
