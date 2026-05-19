package LC743;

import java.util.*;

public class Solution {
    // E: the number of edges
    // V: the number of vertices
    // time: O((E + V) * logV)
    // space: O(E + V)
    public static final int INF = Integer.MAX_VALUE;
    public int networkDelayTime(int[][] times, int n, int k) {
        // Dijkstra
        Map<Integer, List<int[]>> adjMap = new HashMap<>();
        // {nodeId, distance to k}
        Queue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1])); // find the closest nodes
        int[] distance = new int[n + 1];
        // boolean[] visited = new boolean[n + 1];
        Arrays.fill(distance, INF);

        // build the adjacent map
        for (int i = 1; i <= n; i++) {
            adjMap.put(i, new ArrayList<>());
        }
        for (int[] time : times) {
            adjMap.get(time[0]).add(new int[] {time[1], time[2]});
        }

        // start from node k
        minHeap.offer(new int[] {k, 0});
        distance[k] = 0;

        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int curNode = cur[0];
            int curDist = cur[1];
            if (curDist > distance[curNode]) {
                continue; // the node has been visited => the closest distance has been calculated
            }
            distance[curNode] = curDist;

            for (int[] adj : adjMap.get(curNode)) {
                if (curDist + adj[1] < distance[adj[0]]) {
                    minHeap.offer(new int[] {adj[0], adj[1] + curDist});
                }
            }
        }

        int maxDistance = -1;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == INF) {
                return -1;
            }
            maxDistance = Math.max(maxDistance, distance[i]);
        }

        return maxDistance;
    }
}
