package LC1245;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int treeDiameter(int[][] edges) {
        // N: the number of nodes, the number of edges should be N - 1 in a tree
        // time: O(N)
        // space: O(N)
        if (edges.length == 0)
            return 0;
        Map<Integer, Set<Integer>> tree = new HashMap<>();
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            tree.computeIfAbsent(node1, key -> new HashSet<>()).add(node2);
            tree.computeIfAbsent(node2, key -> new HashSet<>()).add(node1);
        }   

        int[] first = BFS(0, tree);
        int[] second = BFS(first[0], tree);

        return second[1] - 1;
    }

    private int[] BFS(int start, Map<Integer, Set<Integer>> tree) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int distance = 0;
        int lastNode = 0;
        boolean[] visited = new boolean[tree.size()];
        visited[start] = true;
        

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int cur = queue.poll();
                lastNode = cur;
                for (int node : tree.getOrDefault(cur, new HashSet<>())) {
                    if (!visited[node]) {
                        queue.add(node);
                        visited[node] = true;
                    }
                }
            }
            distance += 1;
        }

        return new int[] { lastNode, distance };
    }
}
