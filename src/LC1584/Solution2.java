package LC1584;

import java.util.*;

public class Solution2 {
    public int minCostConnectPoints(int[][] points) {
        // time: O(N ^ 2 * logN)
        // space: O(N ^ 2)
        // Prim's Algorithm
        Map<Integer, List<int[]>> adjMap = new HashMap<>();
        int n = points.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] p1 = points[i];
                int[] p2 = points[j];
                int weight = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
                adjMap.computeIfAbsent(i, _ -> new ArrayList<>()).add(new int[] {j, weight});
                adjMap.computeIfAbsent(j, _ -> new ArrayList<>()).add(new int[] {i, weight});
            }
        }

        int minCost = 0;
        Queue<int[]> minEdgeHeap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        boolean[] visited = new boolean[n];
        minEdgeHeap.offer(new int[] {0, 0}); // start from point 0 and the weight is 0


        while (!minEdgeHeap.isEmpty()) {
            int[] cur = minEdgeHeap.poll();
            if (visited[cur[0]]) {
                continue;
            }

            minCost += cur[1];
            visited[cur[0]] = true;

            for (int[] adj : adjMap.getOrDefault(cur[0], new ArrayList<>())) {
                if (!visited[adj[0]]) {
                    minEdgeHeap.offer(adj);
                }
            }
        }

        return minCost;
    }
}
