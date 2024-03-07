package LC787;

import java.util.*;

/**
 * LC 787. Cheapest Flights Within K Stops
 */
public class Solution3 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Dijkstra
        // N: the number of cities
        // E: the number of flights
        // time: O(N + E * K * log(E * K))
        // space: O(N + E * K)
        
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], key -> new ArrayList<>()).add(new int[] { flight[1], flight[2] });
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // [distance, city, number of stops]
        minHeap.add(new int[] { 0, src, 0 });
        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int distance = cur[0];
            int city = cur[1];
            int stop = cur[2];
            if (stop > stops[city] || stop > k + 1)
                continue;
            stops[city] = stop;
            if (city == dst) {
                return distance;
            }
                
            for (int[] adj : graph.getOrDefault(city, new ArrayList<>())) {
                minHeap.add(new int[] { adj[1] + distance, adj[0], stop + 1 });
            }

        }
        
        return -1;
    }
}
