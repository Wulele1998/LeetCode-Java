package LC463;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 463. Island Perimeter
 */
public class Solution {
    public int islandPerimeter(int[][] grid) {
        // M: the number of rows
        // N: the number of columns
        // time: O(M * N)
        // space: O(M * N)
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int border = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // start BFS
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    // mark as visited
                    grid[i][j] = -1;

                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        int x = poll[0], y = poll[1];
                        for (int[] dir : dirs) {
                            int newX = x + dir[0];
                            int newY = y + dir[1];
                            if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] == 0) {
                                // out of grid or water
                                border++;
                            } else if (grid[newX][newY] == 1) {
                                queue.add(new int[]{newX, newY});
                                grid[newX][newY] = -1; // mark as visited
                            }
                        }
                    }
                }
            }
        }
        return border;
    }
}
