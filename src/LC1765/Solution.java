package LC1765;

import java.util.Queue;
import java.util.LinkedList;

/**
 * LC 1765. Map of Highest Peak
 */
public class Solution {
    public int[][] highestPeak(int[][] isWater) {
        // BFS (Breadth First Search)
        // M: the number of rows
        // N: the number of columns
        // time: O(M * N)
        // complexity: O(M * N)
        final int[][] DIRS = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int m = isWater.length;
        int n = isWater[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    isWater[i][j] = 0;
                    queue.add(new int[] {i, j});
                } else {
                    isWater[i][j] = -1;
                }
            }
        }

        int height = 0;
        while (!queue.isEmpty()) {
            height++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for (int[] dir : DIRS) {
                    int row = cell[0] + dir[0];
                    int col = cell[1] + dir[1];
                    if (row >= 0 && row < m && col >= 0 && col < n && isWater[row][col] == -1) {
                        isWater[row][col] = height;
                        queue.add(new int[] {row, col});
                    }
                }
            }
        }

        return isWater;
    }
}
