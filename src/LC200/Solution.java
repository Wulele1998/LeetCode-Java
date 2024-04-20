package LC200;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int numIslands(char[][] grid) {
        // M: the number of rows
        // N: the number of columns
        // time: O(M * N)
        // space: O(M * N_
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    grid[i][j] = '#';

                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        for (int[] dir : dirs) {
                            int x = poll[0] + dir[0];
                            int y = poll[1] + dir[1];
                            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                                queue.add(new int[]{x, y});
                                grid[x][y] = '#';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
