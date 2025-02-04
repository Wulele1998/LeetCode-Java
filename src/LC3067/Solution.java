package LC3067;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 3067. Count Pairs of Connectable Servers in a Weighted Tree Network
 */
public class Solution {
    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int n = edges.length + 1;
        List<List<int[]>> graph = new ArrayList<>();
        int[] res = new int[n];

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            int dis = edge[2];
            graph.get(node1).add(new int[] { node2, dis });
            graph.get(node2).add(new int[] { node1, dis });
        }
        
        for (int i = 0; i < n; i++) {
            int cur = 0;
            int sum = 0;
            for (int[] adj : graph.get(i)) {
                int num = DFS(graph, adj[0], i, signalSpeed, adj[1]);
                cur += sum * num;
                sum += num;
            }
            res[i] = cur;
        }
        
        return res;
    }
    
    private int DFS(List<List<int[]>> graph, int node, int parent, int mod, int distance) {
        int res = distance % mod == 0 ? 1 : 0;

        for (int[] adj : graph.get(node)) {
            if (adj[0] == parent) {
                continue;
            }
            res += DFS(graph, adj[0], node, mod, distance + adj[1]);
        }

        return res;
    }
}
