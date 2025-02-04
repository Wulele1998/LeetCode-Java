package LC1730;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 1730. Shortest Path to Get Food
 */
public class Solution {
    public int getFood(char[][] grid) {
        // BFS
        // M: the number of rows
        // N: the number of columns
        // time complexity: O(M * N)
        // space: O(M * N)
        int m = grid.length;
        int n = grid[0].length;
        int row = -1;
        int col = -1;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < m; i++) {
            Arrays.fill(visited[i], false);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '*') {
                    row = i;
                    col = j;
                    break;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        visited[row][col] = true;
        queue.add(new int[] {row, col});
        int path = 0;
        while (!queue.isEmpty()) {
            ++path;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int row_ = cur[0] + dir[0];
                    int col_ = cur[1] + dir[1];
                    if (row_ >= 0 && row_ < m && col_ >= 0 && col_ < n && !visited[row_][col_]) {
                        if (grid[row_][col_] == '#') {
                            return path;
                        } else if (grid[row_][col_] == 'O') {
                            queue.add(new int[] {row_, col_});
                            visited[row_][col_] = true;
                        }
                    }
                }
            }
        }

        return -1;
    }
}
