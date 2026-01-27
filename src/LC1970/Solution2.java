package LC1970;

public class Solution2 {
    int m; // number of rows
    int n; // number of columns
    final int[][] DIRECTIONS = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int latestDayToCross(int row, int col, int[][] cells) {
        // binary search and DFS
        // M: the number of rows
        // N: the number of columns
        // K: the size of `cells`
        // time: O(logK * M * N)
        // space: O(M * N), grid space and the recursion stack
        m = row + 1; // 1=indexed
        n = col + 1;

        // start binary search [left, right]
        int left = 0;
        int right = cells.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isAbleToCrossDFS(cells, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    /**
     * after `day`, can we still cross the grid using DFS (Depth First Search)
     * @param cells cells covered by water
     * @param day current day
     * @return can or cannot cross the grid
     */
    private boolean isAbleToCrossDFS(int[][] cells, int day) {
        int[][] grid = new int[m][n];
        for (int i = 0; i <= day; i++) {
            grid[cells[i][0]][cells[i][1]] = 1; // covered by the water
        }

        for (int c  = 0; c < n; c++) {
            if (grid[0][c] == 0 && DFS(grid, 0, c)) {
                return true;
            }
        }

        return false;
    }

    /**
     * DFS search
     * @param grid grid graph
     * @param row row of current cell
     * @param col column of current cell
     * @return if the DFS path can arrive the bottom row
     */
    private boolean DFS(int[][] grid, int row, int col) {
        if (row < 1 || row >= m || col < 1 || col >= n || grid[row][col] != 0) {
            return false;
        }
        if (row == m - 1) {
            return true; // arrive the bottom row
        }
        grid[row][col] = -1; // mark as visited
        for (int[] dir : DIRECTIONS) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if (DFS(grid, nextRow, nextCol)) {
                return true;
            }
        }

        return false;
    }
}
