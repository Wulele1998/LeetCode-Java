package LC1970;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 1970 Last Day Where You Can Still Cross
 */
public class Solution {
    int m; // number of rows
    int n; // number of columns
    final int[][] DIRECTIONS = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int latestDayToCross(int row, int col, int[][] cells) {
        // binary search and BFS
        // M: the number of rows
        // N: the number of columns
        // K: the size of `cells`
        // time: O(logK * M * N)
        // space: O(M * N), grid space and the queue
        m = row + 1; // 1=indexed
        n = col + 1;

        // start binary search [left, right]
        int left = 0;
        int right = cells.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isAbleToCrossBFS(cells, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    /**
     * after `day`, can we still cross the grid using BFS (Breadth First Search)
     * @param cells cells covered by water
     * @param day current day
     * @return can or cannot cross the grid
     */
    private boolean isAbleToCrossBFS(int[][] cells, int day) {
        int[][] grid = new int[m][n]; // initialize the grid, all cells is 0 - land
        // 0 - land
        // 1 - water
        // -1 - visited land
        for (int i = 0; i <= day; i++) {
            grid[cells[i][0]][cells[i][1]] = 1; // cell is covered by water 1 - water
        }

        Queue<int[]> queue = new LinkedList<>(); // use for breadth first search
        for (int c = 0; c < n; c++) {
            // pass the first row to find all the entries on the top
            if (grid[0][c] == 0) {
                queue.add(new int[] {0, c});
                grid[0][c] = -1; // mark as visited
            }
        }

        if (queue.isEmpty()) {
            // no entry available
            return false;
        }

        while (!queue.isEmpty()) {
            int[] curCell = queue.poll();
            for (int[] dir : DIRECTIONS) {
                int nextRow = curCell[0] + dir[0];
                int nextCol = curCell[1] + dir[1];
                if (nextRow >= 1 && nextRow < m && nextCol >= 1 && nextCol < n && grid[nextRow][nextCol] == 0) {
                    if (nextRow == m - 1) {
                        // reach the bottom row, cross the whole grid successfully
                        return true;
                    }
                    queue.add(new int[] {nextRow, nextCol});
                    grid[nextRow][nextCol] = -1; // mark as visited
                }
            }
        }

        return false;
    }
}
