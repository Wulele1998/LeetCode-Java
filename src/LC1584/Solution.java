package LC1584;

import java.util.PriorityQueue;
import java.util.Queue;

class DSU {
    int n;
    int[] ancestor;
    int[] familySize;

    public DSU(int n) {
        this.n = n;
        ancestor = new int[n];
        familySize = new int[n];

        for (int i = 0; i < n; i++) {
            ancestor[i] = i;
            familySize[i] = 1;
        }
    }

    public int find(int node) {
        while (node != ancestor[node]) {
            node = ancestor[node];
        }

        return node;
    }

    public boolean isUnion(int node1, int node2) {
        int anc1 = find(node1);
        int anc2 = find(node2);

        if (anc1 == anc2) {
            return false;
        }
        if (familySize[anc1] >= familySize[anc2]) {
            // combine anc2 into anc1
            ancestor[anc2] = anc1;
            familySize[anc1] += familySize[anc2];
        } else {
            ancestor[anc1] = anc2;
            familySize[anc2] += familySize[anc1];
        }

        return true;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        // N: the number of points
        // time: O(N ^ 2 * logN)
        // space: O(N ^ 2)
        // Kruskal's Algorithm
        // 1) always find the cheapest edge from the edges
        // 2) merge the two graph (nodes) using the edge

        // {node1, node2, weight}
        Queue<int[]> minEdgeHeap = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        int n = points.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] p1 = points[i];
                int[] p2 = points[j];
                int weight = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
                minEdgeHeap.offer(new int[] {i, j, weight});
            }
        }

        int minCost = 0;
        DSU dsu = new DSU(n);
        while (!minEdgeHeap.isEmpty()) {
            int[] cur = minEdgeHeap.poll();
            int node1 = cur[0];
            int node2 = cur[1];
            if (dsu.isUnion(node1, node2)) {
                minCost += cur[2];
            }
        }

        return minCost;
    }
}