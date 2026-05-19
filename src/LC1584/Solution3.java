package LC1584;

import java.util.Arrays;

public class Solution3 {
    public static final int INF = Integer.MAX_VALUE;
    public int minCostConnectPoints(int[][] points) {
        // N: the number of nodes
        // time: O(N ^ 2)
        // space: O(N)
        // Prim's Algorithm without using Heap (Optimized)
        // MST: minimum spanning tree
        int minCost = 0;
        int n = points.length; // number of points
        int usedEdges = 0;
        boolean[] visited = new boolean[n];
        int[] minDistances = new int[n]; // store the minimum wight of edge that can reach point i from the MST
        Arrays.fill(minDistances, INF);

        // start from point 0
        minDistances[0] = 0;

        while (usedEdges < n) {
            // find the minimum edge point among the unvisited points
            int minIndex = -1;
            int minWeight = INF;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && minDistances[i] < minWeight) {
                    minWeight = minDistances[i];
                    minIndex = i;
                }
            }

            // add point minIndex into the MST
            minCost += minWeight;
            visited[minIndex] = true;
            usedEdges++;

            // update the minDistances from the new added points to all other unvisited points
            int[] minPoint = points[minIndex];
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int[] adjPoint = points[i];
                    int weight = Math.abs(minPoint[0] - adjPoint[0]) + Math.abs(minPoint[1] - adjPoint[1]);
                    if (weight < minDistances[i]) {
                        minDistances[i] = weight;
                    }
                }
            }
        }

        return minCost;
    }
}
