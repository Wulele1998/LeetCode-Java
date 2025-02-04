package LC261;

import java.util.*;

/**
 * LC 261. Graph Valid Tree
 */
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // N: the number of nodes
        // the number of `edges` should be N - 1 if it is a tree
        // time: O(N)
        // space: O(N)
        // edges number limit
        if (edges.length != n - 1) {
            return false;
        }

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        // Breadth First Search (BFS)
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int node : map.get(cur)) {
                if (!visited[node]) {
                    queue.add(node);
                    visited[node] = true;
                }
            }
        }


        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }
}
