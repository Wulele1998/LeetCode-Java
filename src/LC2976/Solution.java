package LC2976;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Jan 29, 2026
 * LC 2976. Minimum Cost to Convert String I
 */
public class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        // cost[i] >= 0
        // no negative weight => shortest path => Dijkstra
        // V: the length of `source` and `target`
        // E: the length of `cost` => the number of edges
        // Time: O((E + V) * logV)
        // space: O(V + E)
        int n = cost.length;
        Map<Integer, Map<Integer, Integer>> graphMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int start = original[i] - 'a';
            int end = changed[i] - 'a';
            int weight = cost[i];
            if (!graphMap.containsKey(start)) {
                graphMap.put(start, new HashMap<>());
            }
            Map<Integer,Integer> map = graphMap.get(start);
            map.put(end, Math.min(weight, map.getOrDefault(end, Integer.MAX_VALUE))); // if there is duplicate edges, only save the minimum weight
        }

        long[][] res = new long[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(res[i], Long.MAX_VALUE);

            // start Dijkstra 
            dijkstra(graphMap, i, res);
        }

        int m = source.length();
        long totalCost = 0L;
        for (int i = 0; i < m; i++) {
            if (source.charAt(i) != target.charAt(i)) {
                int srcIndex = source.charAt(i) - 'a';
                int dstIndex = target.charAt(i) - 'a';
                if (res[srcIndex][dstIndex] == Long.MAX_VALUE) {
                    return -1;
                } else {
                    totalCost += res[srcIndex][dstIndex];
                }
            }
        }
        
        return totalCost;

    }

    // O(V * log V)
    private void dijkstra(Map<Integer, Map<Integer,Integer>> graphMap, int src, long[][] res) {
        boolean[] visited = new boolean[26];
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (o1, o2) -> o1.getValue() - o2.getValue()
        );
        
        minHeap.add(Map.entry(src, 0)); // start from source character
        
        while (!minHeap.isEmpty()) {
            Map.Entry<Integer, Integer> current = minHeap.poll();
            int letter = current.getKey();
            int weight = current.getValue();

            if (visited[letter]) {
                continue;
            }

            res[src][letter] = weight;
            visited[letter] = true;

            if (graphMap.containsKey(letter)) {
                for (Map.Entry<Integer, Integer> adj : graphMap.get(letter).entrySet()) {
                    int dstIndex = adj.getKey();
                    if (res[src][dstIndex] > adj.getValue() + weight) {
                        // relax operation
                        minHeap.add(Map.entry(adj.getKey(), adj.getValue() + weight));
                    }
                }
            }
        }
    }
}
