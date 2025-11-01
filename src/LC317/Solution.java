package LC317;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 317. Shortest Distance from All Buildings
 */
public class Solution {
    private int m;
    private int n;
    private int houseNumber;
    public int shortestDistance(int[][] grid) {
        // Using BFS search, from each empty land to each house
        // M: the number of rows
        // N: the number of columns
        // time: O(M * N * M * N)
        // space: O(M * N)
        m = grid.length;
        n = grid[0].length;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    houseNumber++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    // empty place, start the BFS
                    minDistance = Math.min(minDistance, BFS(grid, i, j));
                }
            }
        }

        if (minDistance == Integer.MAX_VALUE) {
            return -1;
        } else {
            return minDistance;
        }
    }

    private int BFS(int[][] grid, int i, int j) {
        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        int distance = 0;
        int sum = 0;
        int visitedHouse = 0;
        boolean[][] visited = new boolean[m][n];

        queue.add(new int[] {i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for (int k = 0; k < size; k++) {
                int[] cur  = queue.poll();
                for (int[] d : directions) {
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != 2 && !visited[x][y]) {
                        if (grid[x][y] == 1) {
                            // find the house
                            sum += distance;
                            visitedHouse++;
                        } else {
                            visited[x][y] = true;
                        }
                        queue.add(new int[] {x, y});
                    }
                }
            }
        }
        if (visitedHouse == houseNumber)
            return sum;
        else
            return Integer.MAX_VALUE;
    }
}
