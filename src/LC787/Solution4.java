package LC787;

import java.util.*;

public class Solution4 {
    public static final int INF = Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adjMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjMap.put(i, new ArrayList<>());
        }
        for (int[] flight : flights) {
            int start = flight[0];
            int end = flight[1];
            int price = flight[2];
            adjMap.get(start).add(new int[] {end, price});
        }
        int[] prices = new int[n];
        int[] stops = new int[n];
        Arrays.fill(prices, INF);
        Arrays.fill(stops, INF);
        // Dijkstra
        // {node, price, stop}
        // sort based on price
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        minHeap.offer(new int[] {src, 0, -1});

        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int curNode = cur[0];
            int curPrice = cur[1];
            int curStop = cur[2];

            if (curStop > k || curStop >= stops[curNode]) {
                continue; // this node cannot be used,
            }

            prices[curNode] = Math.min(prices[curNode], curPrice);
            // System.out.println(Arrays.toString(prices));
            stops[curNode] = curStop;

            for (int[] adjNode : adjMap.get(curNode)) {
                // relax operation
                int nextNode = adjNode[0];
                int nextPrice = curPrice + adjNode[1];
                int nextStop = curStop + 1;
                if (nextPrice < prices[nextNode] || nextStop < stops[nextNode]) {
                    minHeap.offer(new int[] {nextNode, nextPrice, nextStop});
                }
            }
        }

        return prices[dst] == INF ? -1 : prices[dst];
    }
}
