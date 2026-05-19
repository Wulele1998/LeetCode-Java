package LC695;

public class Solution {
    public static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static final int LAND = 1;
    public static final int WATER = 0;
    private int m; // row number
    private int n; // col number
    private boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        // edge case: the grid is empty
        if (grid.length == 0 || grid[0].length == 0)
            return 0;

        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n]; // default be false

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // for each unvisited cell in the grid, execute DFS to mark the island
                if (!visited[i][j] && grid[i][j] == LAND) {
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }

        return res;
    }

    /**
     * DFS recursion helper method
     * @param grid grid
     * @param row the row index of current cell
     * @param col the column index of current cell
     * @return the size of the island after execute DFS from current cell
     */
    private int dfs(int[][] grid, int row, int col) {
        int area = 0;

        visited[row][col] = true;
        area++; // current cell

        for (int[] d : DIRECTIONS) {
            int nextR = row + d[0];
            int nextC = col + d[1];
            if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && !visited[nextR][nextC] && grid[nextR][nextC] == LAND) {
                area += dfs(grid, nextR, nextC);
            }
        }

        return area;
    }
}
