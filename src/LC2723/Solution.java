package LC2723;

/**
 * LC 2373. Largest Local Values in a Matrix
 */
public class Solution {
    public int[][] largestLocal(int[][] grid) {
        // M: the number of rows in `grid`
        // N: the number of columns in `grid`
        // time: O(M * N)
        // space: O(M * N)
        int m = grid.length;
        int n = grid[0].length;
        int row = m - 2;
        int col = n - 2;
        int[][] res = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int max = 0;   
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        max = Math.max(max, grid[k][l]);
                    }
                }

                res[i][j] = max;
            }
        }

        return res;
    }
}
