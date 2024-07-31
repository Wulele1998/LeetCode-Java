package LC1334;

/**
 * LC 1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance
 */
public class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = Integer.MAX_VALUE / 2;
            }
            distance[i][i] = 0;
        }

        for (int[] edge : edges) {
            distance[edge[0]][edge[1]] = edge[2];
            distance[edge[1]][edge[0]] = edge[2];
        }

        for (int start = 0; start < n; start++) {
            for (int end = 0; end < n; end++) {
                for (int mid = 0; mid < n; mid++) {
                    if (distance[start][end] > distance[start][mid] + distance[mid][end]) {
                        distance[start][end] = distance[start][mid] + distance[mid][end];
                    }
                }
            }
        }

        int resCity = -1;
        int reachableCount = n;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && distance[i][j] < distanceThreshold) {
                    count++;
                }
            }

            if (count < reachableCount) {
                reachableCount = count;
                resCity = i;
            }
        }

        return resCity;
    }
}
