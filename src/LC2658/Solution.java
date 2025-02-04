package LC2658;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 2658. Maximum Number of Fish in a Grid
 */
public class Solution {
    public int findMaxFish(int[][] grid) {
        // Breadth First Search (BFS)
        // M: the number of rows
        // N: the number of columns
        // time: O(M * N)
        // space: O(M * N)
        final int[][] DIRS = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                if (grid[i][j] > 0) {
                    count = grid[i][j];
                    grid[i][j] = -1;

                    queue.add(new int[] {i, j});
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        for (int[] dir : DIRS) {
                            int row = dir[0] + cur[0];
                            int col = dir[1] + cur[1];
                            if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] > 0) {
                                count += grid[row][col];
                                grid[row][col] = -1;
                                queue.add(new int[] {row, col});
                            }
                        }
                    }

                    res = Math.max(res, count);
                }
            }
        }

        return res;
    }
}
