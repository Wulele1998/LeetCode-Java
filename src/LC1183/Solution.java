package LC1183;

import java.util.*;

/**
 * Nov 6, 2025
 * LC 3607. Power Grid Maintenance
 */
public class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        Map<Integer, List<Integer>> grid = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            grid.put(i, new ArrayList<>());
        }
        for (int[] connection : connections) {
            // bidirectional
            grid.get(connection[0]).add(connection[1]);
            grid.get(connection[1]).add(connection[0]);
        }

        boolean[] offline = new boolean[c + 1]; // all false at initial, means all online
        int[] nodeToMapId = new int[c + 1];
        int mapId = 1;
        for (int i = 1; i <= c; i++) {
            if (nodeToMapId[i] == 0) {
                // start BFS search to find the grid
                BFS(i, nodeToMapId, grid, mapId);
                mapId++;
            }
        }

        TreeSet<Integer>[] mapIdToMapNodes = new TreeSet[mapId];
        for (int i = 1; i < mapId; i++) {
            mapIdToMapNodes[i] = new TreeSet<>();
        }
        for (int i = 1; i <= c; i++) {
            mapIdToMapNodes[nodeToMapId[i]].add(i);
        }

        List<Integer> res = new ArrayList<>();
        for (int[] query : queries) {
            if (query[0] == 2) {
                offline[query[1]] = true;
                mapIdToMapNodes[nodeToMapId[query[1]]].remove(query[1]);
            } else {
                // query[0] == 1
                res.add(findResolve(query[1], mapIdToMapNodes[nodeToMapId[query[1]]], offline));
            }
        }

        int[] resArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }

        return resArray;
    }

    private void BFS(int start, int[] nodeToMapId, Map<Integer, List<Integer>> grid, int mapId) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        nodeToMapId[start] = mapId;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i : grid.get(current)) {
                if (nodeToMapId[i] == 0) {
                    queue.add(i);
                    nodeToMapId[i] = mapId;
                }
            }
        }
    }

    private int findResolve(int target, TreeSet<Integer> nodes, boolean[] offline) {
        if (!offline[target]) {
            return target;
        }

        return nodes.isEmpty() ? -1 : nodes.first();
    }
}
