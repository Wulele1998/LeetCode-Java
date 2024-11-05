package LC2482;

public class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        // M: the number of row
        // N: the number of columns
        // time: O(M * N)
        // space: O(1)
        int m = grid.length;
        int n = grid[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = rows[i] + cols[j] - (m - rows[i]) - (n - cols[j]);
            }
        }

        return grid;
    }
}
