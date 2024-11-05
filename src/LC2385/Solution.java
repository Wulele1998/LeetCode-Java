package LC2385;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Queue;

import library.TreeNode;

public class Solution {
    public int amountOfTime(TreeNode root, int start) {
        // BFS
        // time: O(N)
        // space: O(N ^ 2)
        Map<Integer, Set<Integer>> map = new HashMap<>();
        saveTree(root, map, -1);

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(start);
        int time = 0;

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int cur = queue.poll();
                visited.add(cur);
                for (int adj : map.get(cur)) {
                    if (!visited.contains(adj)) {
                        queue.add(adj);
                    }
                }
            }
            time++;
        }

        return time - 1;
    }

    private void saveTree(TreeNode root, Map<Integer, Set<Integer>> map, int parent) {
        if (root == null)
            return;
        Set<Integer> adj = new HashSet<>();
        if (parent != -1)
            adj.add(parent);
        map.put(root.val, adj);
        if (parent != -1)
            map.get(parent).add(root.val);
        saveTree(root.left, map, root.val);
        saveTree(root.right, map, root.val);
    }
}
