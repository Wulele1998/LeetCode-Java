package LC2467;

import java.util.*;

/**
 * LC 2467. Most Profitable Path in a Tree
 */
public class Solution {
    boolean[] visited;
    Map<Integer, Integer> bobPath;
    Map<Integer, List<Integer>> graph;
    int maxIncome = Integer.MIN_VALUE;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        // two DFS / BFS + DFS
        // N: the number of nodes in the tree
        // time: O(N)
        // space: O(N)
        // use HashMap to save the edges
        graph = new HashMap<>();

        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }
        int n = amount.length;
        // Bob's path is fixed since it need to find the root of the tree
        // use DFS to get Bob's path
        bobPath = new HashMap<>();
        visited = new boolean[n];
        findBobPathDFS(bob, 0);
        // findBobPathBFS(bob);
        // BFS for Alice
//        aliceBFS(amount);

        // DFS for Alice
        Arrays.fill(visited, false); // reset the visited array for Alice
        aliceDFS(0, 0, 0, amount);
        return maxIncome;
    }

    private void findBobPathBFS(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { start, 0 });
        visited[start] = true;
        Map<Integer, Integer> childToParent = new HashMap<>();
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();

                if (node[0] == 0) {
                    // reach the tree root
                    int child = 0;
                    int curTime = node[1];
                    while (childToParent.containsKey(child)) {
                        bobPath.put(child, curTime--);
                        child = childToParent.get(child);
                    }
                    bobPath.put(start, 0);
                    return;
                }

                for (int adj : graph.get(node[0])) {
                    if (!visited[adj]) {
                        queue.add(new int[] { adj, node[1] + 1 });
                        visited[adj] = true;
                        childToParent.put(adj, node[0]);
                    }
                }
            }
        }
    }

    private boolean findBobPathDFS(int cur, int time) {
        bobPath.put(cur, time);
        visited[cur] = true;

        if (cur == 0) {
            // Bob arrived
            return true;
        }

        for (int adj : graph.get(cur)) {
            if (!visited[adj]) {
                if (findBobPathDFS(adj, time + 1)) {
                    return true;
                }
            }
        }

        // undo the operation and try others
        bobPath.remove(cur);
        return false;
    }

    private void aliceBFS(int[] amount) {
        Arrays.fill(visited, false); // reset the visited for Alice
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 0}); // {node, time, alice income}
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0];
            int time = cur[1];
            int income = cur[2];

            visited[node] = true;
            // get the time of bob if he this node is in his path
            int bobArriveTime = bobPath.getOrDefault(node, Integer.MAX_VALUE);
            if (bobArriveTime == time) {
                income += amount[node] / 2;
            } else if (bobArriveTime > time) {
                income += amount[node];
            }
            // else: the gate has been opened by Bob before, which income is 0, can be ignored
            // after update the income, need to check if Alice has arrived at the leaf node
            if (graph.get(node).size() == 1 && node != 0) {
                maxIncome = Math.max(maxIncome, income);
            } else {
                // not a leaf node, continue BFS search
                for (int adj : graph.get(node)) {
                    if (!visited[adj]) {
                        queue.add(new int[] {adj, time + 1, income});
                    }
                }
            }
        }

    }

    private void aliceDFS(int cur, int time, int income, int[] amount) {
        visited[cur] = true; // set as visited
        int bobArriveTime = bobPath.getOrDefault(cur, Integer.MAX_VALUE);
        if (bobArriveTime == time) {
            income += amount[cur] / 2; // split the income
        } else if (bobArriveTime > time) {
            income += amount[cur];
        }

        if (graph.get(cur).size() == 1 && cur != 0) {
            // arrive at one leaf node
            // update the max income for Alice
            maxIncome = Math.max(maxIncome, income);
        } else {
            for (int adj : graph.get(cur)) {
                if (!visited[adj]) {
                    aliceDFS(adj, time + 1, income, amount);
                }
            }
        }
    }
}
