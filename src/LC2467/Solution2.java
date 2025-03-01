package LC2467;

import java.util.*;

/**
 * LC 2467. Most Profitable Path in a Tree
 */
public class Solution2 {
    Map<Integer, List<Integer>> graph;
    int[] distanceFromBob;
    int maxIncome = 0;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }
        distanceFromBob = new int[n];
        System.out.println(Arrays.toString(distanceFromBob));
        return findPath(0, 0, 0, bob, amount);

    }

    private int findPath(int node, int parentNode, int time, int bob, int[] amount) {
        int maxChild = Integer.MIN_VALUE;
        if (node == bob) {
            distanceFromBob[node] = 0;
        } else {
            distanceFromBob[node] = amount.length;
        }

        for (int adj : graph.get(node)) {
            if (adj != parentNode) {
                maxChild = Math.max(maxChild, findPath(adj, node, time + 1, bob, amount));
                distanceFromBob[node] = Math.min(distanceFromBob[node], distanceFromBob[adj] + 1);
            }
        }

        if (distanceFromBob[node] > time) {
            maxIncome += amount[node];
        } else if (distanceFromBob[node] == time) {
            maxIncome += amount[node] / 2;
        }

        return maxChild == Integer.MIN_VALUE ? maxIncome : maxIncome + maxChild;
    }
}
