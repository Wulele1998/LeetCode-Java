package LC778;

import java.util.PriorityQueue;

public class Solution {
    // M: the number of rows
    // N: the number of columns
    // M * N: the number of nodes
    // time: O(M * N * log(M * N))
    public static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int swimInWater(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0; // edge case
        }

        int m = grid.length; // number of rows
        int n = grid[0].length; // number of columns

        // Dijkstra
        // {row, col, elevation}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        boolean[][] visited = new boolean[m][n];

        minHeap.offer(new int[] {0, 0, grid[0][0]});
        visited[0][0] = true;

        while (!minHeap.isEmpty()) {
            int[] cell = minHeap.poll();
            int r = cell[0];
            int c = cell[1];
            int waterLevel = cell[2];

            if (r == m - 1 && c == n - 1) {
                return waterLevel;
            }

            for (int[] d : DIRECTIONS) {
                int nextR = r + d[0];
                int nextC = c + d[1];
                if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && !visited[nextR][nextC]) {
                    minHeap.offer(new int[] {nextR, nextC, Math.max(grid[nextR][nextC], waterLevel)});
                    visited[nextR][nextC] = true;
                }
            }
        }

        return -1;
    }
}
