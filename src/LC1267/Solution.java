package LC1267;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 1267. Count Servers that Communicate
 */
public class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        boolean[] visitedRow = new boolean[m];
        boolean[] visitedCol = new boolean[n];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                if (grid[i][j] == 1) {
                    queue.add(new int[] {i, j});
                    grid[i][j] = -1;
                    count++;
                }

                while (!queue.isEmpty()) {
                    int[] cell = queue.poll();
                    if (!visitedRow[cell[0]]) {
                        for (int k = 0; k < n; k++) {
                            if (grid[cell[0]][k] == 1) {
                                queue.add(new int[] {cell[0], k});
                                grid[cell[0]][k] = -1;
                                count++;
                            }
                        }
                        visitedRow[cell[0]] = true;
                    }

                    if (!visitedCol[cell[1]]) {
                        for (int k = 0; k < m; k++) {
                            if (grid[k][cell[1]] == 1) {
                                queue.add(new int[]{k, cell[1]});
                                grid[k][cell[1]] = -1;
                                count++;
                            }
                        }
                        visitedCol[cell[1]] = true;
                    }
                }

                res += count;
            }
        }

        return res;
    }
}
