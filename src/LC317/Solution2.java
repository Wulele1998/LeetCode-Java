package LC317;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 317. Shortest Distance from All Buildings
 */
public class Solution2 {
    public int shortestDistance(int[][] grid) {
        // using BFS from each house
        // M: the number of rows
        // N: the number of columns
        // time: O(M * N * M * N)
        // space: O(M * N)
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int minDistance = Integer.MAX_VALUE;
        int[][] distance = new int[m][n];
        int emptyVal = 0; // use the dynamic empty value to find the qualified empty cell

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // BFS for the house
                    minDistance = Integer.MAX_VALUE;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    int step = 0;

                    while (!queue.isEmpty()){
                        int size = queue.size();
                        step++;
                        for (int k = 0; k < size; k++){
                            int[] cur = queue.poll();
                            for (int[] d : directions){
                                int x = cur[0] + d[0];
                                int y = cur[1] + d[1];
                                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == emptyVal) {
                                    queue.add(new int[]{x, y});
                                    grid[x][y]--;
                                    distance[x][y] += step;
                                    minDistance = Math.min(minDistance, distance[x][y]);
                                }
                            }
                        }
                    }

                    emptyVal--;
                }
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}
