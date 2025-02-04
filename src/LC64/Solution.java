package LC64;

/**
 * LC 64. Minimum Path Sum
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        // M: the number of rows
        // N: the number of columns
        // time: O(M * N)
        // space: O(1)
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[m - 1][n - 1];
    }
}
