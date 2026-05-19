package LC200;

public class Solution2 {
    public static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static final char LAND = '1';
    public static final char WATER = '0';
    private int m; // row number
    private int n; // col number
    private boolean[][] visited;

    public int numIslands(char[][] grid) {
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
                    dfs(grid, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int row, int col) {
        visited[row][col] = true;

        for (int[] d : DIRECTIONS) {
            int nextR = row + d[0];
            int nextC = col + d[1];
            if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && !visited[nextR][nextC] && grid[nextR][nextC] == LAND) {
                dfs(grid, nextR, nextC);
            }
        }
    }
}
