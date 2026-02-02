package LC2977;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Jan 30, 2026
 * LC 2977. Minimum Cost to Convert String II
 */

public class Solution2 {
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        Map<String, Map<String, Integer>> minCostResult = floydWarshall(original, changed, cost);

        // Dynamic Programming
        // dp[i]: the minimum cost to make first i characters in source and tagret same
        // case 1: source[i] == target[i], dp[i] = dp[i - 1]
        // case 2: source[i] != target[i], dp[i] = dp[j] + cost[ source[j + 1, i], target[j + 1, i]] // get the minimum
        // dp[i] = min(case 1, case 2)
        int n = source.length();
        long[] dp = new long[n + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0L;
        
        for (int i = 1; i <= n; i++) {
            int index = i - 1;
            if (source.charAt(index) == target.charAt(index)) {
                dp[i] = Math.min(dp[i], dp[i - 1]); // 
            }
        
            for (int j = index; j >= 0; j--) {
                String subSource = source.substring(j, i);
                String subTarget = target.substring(j, i);
                if (subSource.equals(subTarget)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                } else {
                    if (minCostResult.containsKey(subSource) && minCostResult.get(subSource).containsKey(subTarget) && dp[j] != Long.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[j] + minCostResult.get(subSource).get(subTarget));
                    }
                }
            }
        }

        return dp[n] == Long.MAX_VALUE ? -1 : dp[n];
    }   
    
    private Map<String, Map<String, Integer>> floydWarshall(String[] original, String[] changed, int[] cost) {
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        
        for (int i = 0; i < original.length; i++) {
            String start = original[i];
            String end = changed[i];
            if (!graph.containsKey(start)) {
                graph.put(start, new HashMap<>());
            }
            if(!graph.containsKey(end)) {
                graph.put(end, new HashMap<>());
            }
            int oldVal = graph.get(start).getOrDefault(end, Integer.MAX_VALUE);
            graph.get(start).put(end, Math.min(cost[i], oldVal));
        }

        // FLoyd-Warshall
        List<String> stringSet = new ArrayList<>();
        stringSet.addAll(graph.keySet());

        for (String k : stringSet) {
            for (String i : stringSet) {
                for (String j : stringSet) {
                    if (graph.get(i).containsKey(k) && graph.get(k).containsKey(j)) {
                        // relax operation
                        if (!graph.get(i).containsKey(j)) {
                            // string i cannot reach string j before
                            graph.get(i).put(j, graph.get(i).get(k) + graph.get(k).get(j));
                        } else {
                            int existVal = graph.get(i).get(j);
                            graph.get(i).put(j, Math.min(existVal, graph.get(i).get(k) + graph.get(k).get(j)));
                        }
                    }
                }
            }
        }

        return graph;
    }
}
