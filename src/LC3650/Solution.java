package LC3650;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Jan 26, 2026
 * LC 3650. Minimum Cost Path with Edge Reversals
 */
public class Solution {
    public int minCost(int n, int[][] edges) {
        // N: the number of nodes
        // E: the number of edges
        // time: O(N + E log E)
        // space: O(N + E)
        // Dijkstra
        HashMap<Integer, List<int[]>> adjMap = new HashMap<>();
        // O(E)
        for (int[] edge : edges) {
            adjMap.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(new int[] {edge[1], edge[2]});
            adjMap.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(new int[] {edge[0], 2 * edge[2]});
        }
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); // [node id, distance]
        boolean[] visited = new boolean[n];
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);

        // start from node 0
        minHeap.add(new int[] {0, 0});
        res[0] = 0;

        // O()
        while (!minHeap.isEmpty()) {
            int[] node = minHeap.poll();
            int nodeId = node[0];
            int nodeDistance = node[1];
            if (nodeId == n - 1) {
                return nodeDistance;
            }
            if (visited[nodeId]) {
                continue;
            }
            visited[nodeId] = true; // for the closest node, mark as visited, since we won't visited again

            for (int[] adjNode : adjMap.getOrDefault(nodeId, new ArrayList<>())) {
                int adjId = adjNode[0];
                int adjWeight = adjNode[1];
                if (!visited[adjId] && res[adjId] > adjWeight + nodeDistance) {
                    // relax operation
                    res[adjId] = adjWeight + nodeDistance;
                    minHeap.add(new int[] {adjId, res[adjId]});
                }
            }
        }

        return -1;
    }
}