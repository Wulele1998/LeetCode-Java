package LC2977;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution3 {
    public static final long INF = Long.MAX_VALUE;
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        Map<String, Integer> stringToIndex = new HashMap<>();
        Set<Integer> strLength = new HashSet<>();
        
        int strIndex = 0;
        for (int i = 0; i < original.length; i++) {
            String start = original[i];
            String end = changed[i];
            if (!stringToIndex.containsKey(start)) {
               stringToIndex.put(start, strIndex++);
            }
            if (!stringToIndex.containsKey(end)) {
                stringToIndex.put(end, strIndex++);
            }
            strLength.add(start.length());
            strLength.add(end.length());
        }

        int n = stringToIndex.size();
        long[][] distance = new long[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], INF);
            distance[i][i] = 0L;
        }

        for (int i = 0; i < original.length; i++) {
            int startIndex = stringToIndex.get(original[i]);
            int endIndex = stringToIndex.get(changed[i]);
            distance[startIndex][endIndex] = Math.min(cost[i], distance[startIndex][endIndex]);
        }
        
        floydWarshall(distance, n);

        // start DP
        int m = source.length();
        long[] dp = new long[m + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0L;

        // index i => dp[i + 1]
        for (int i = 0; i < n; i++) {
            if (dp[i] == INF) {
                continue; // cannot match
            }
            if (source.charAt(i) == target.charAt(i)) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i] + 0);
            }
            
            // match the substring [i, i + len)
            for (int len : strLength) {
                if (i + len > n) {
                    continue;
                }

                String subSource = source.substring(i, i + len);
                String subTarget = target.substring(i, i + len);
                if (stringToIndex.containsKey(subSource) && stringToIndex.containsKey(subTarget)) {
                    int indexSubSrc = stringToIndex.get(subSource);
                    int indexSubTag = stringToIndex.get(subTarget);
                    if (distance[indexSubSrc][indexSubTag] != INF) {
                        dp[i + len] = Math.min(dp[i + len], dp[i] + distance[indexSubSrc][indexSubTag]);
                    }
                }
            }
        }

        return dp[n] == INF ? -1L : dp[n];

    }

    private void floydWarshall(long[][] distance, int n) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (distance[i][k] != INF) {
                    for (int j = 0; j < n; j++) {
                        if (distance[k][j] != INF) {
                            distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                        }
                    }
                }
            }
        }
    }
}
