package LC1971;

import java.util.*;

/**
 * LC 1971. Find if Path Exists in Graph
 */
public class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // BFS
        // V: the number of nodes
        // E: the number of edges
        // time: O(V + E)
        // space: O(V + E), V for the queue and E for the adjacent map
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : map.get(cur)) {
                if (next == destination) {
                    return true;
                }
                if (!visited.contains(next)) {
                    queue.add(next);
                    visited.add(next);
                }
            }
        }
        return false;
    }
}
