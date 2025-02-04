package LC2852;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 2852. Sum of Remoteness of All Cells
 */
public class Solution {
    public long sumRemoteness(int[][] grid) {
        // BFS (Breadth First Search)
        // N: the size of grid
        // time: O(N ^ 2) each cell one time in the BFS
        // space: O(N ^ 2)
        int n = grid.length;
        long res = 0L;
        long sum = 0L;
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != -1) {
                    sum += grid[i][j];
                }
            }

        }

        // BFS
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    int count = 1;
                    long graphSum = grid[i][j];
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[] {i, j});
                    grid[i][j] = -2; // visited

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        for (int[] dir : dirs) {
                            int row = dir[0] + cur[0];
                            int col = dir[1] + cur[1];
                            if (row >= 0 && row < n && col >= 0 && col < n && grid[row][col] > 0) {
                                count++;
                                graphSum += grid[row][col];
                                grid[row][col] = -2;
                                queue.add(new int[] {row, col});
                            }
                        }
                    }

                    res += (sum - graphSum) * count;
                }
            }
        }

        return res;
    }
}
