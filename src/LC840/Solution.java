package LC840;

import java.util.Arrays;

/**
 * Dec 30, 2025
 * LC 840. Magic Squares In Grid
 */
public class Solution {
    int m; // number of rows
    int n; // number of columns
    public int numMagicSquaresInside(int[][] grid) {
        // M: the number of rows
        // N: the number of columns
        // time: O(M * N)
        // space: O(1)
        m = grid.length;
        n = grid[0].length;
        int res = 0;

        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                if (isMagicGrid(grid, i, j)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean isMagicGrid(int[][] grid, int row, int col) {
        return checkSumValid(grid, row, col) && checkNumbersValid(grid, row, col);
    }

    private boolean checkNumbersValid(int[][] grid, int row, int col) {
        boolean[] existed = new boolean[10];
        Arrays.fill(existed, false);
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (grid[i][j] < 1 || grid[i][j] > 9) {
                    return false;
                }
                if (existed[grid[i][j]]) {
                    return false;
                }
                existed[grid[i][j]] = true; // mark number as existed
            }
        }

        for (int i = 1; i <= 9; i++) {
            if (!existed[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSumValid(int[][] grid, int row, int col) {
        // check each column sum is 15
        for (int i = col; i < col + 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += grid[row + j][i];
            }
            if (sum != 15) {
                return false;
            }
        }
        // check each row sum is 15
        for (int i = row; i < row + 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += grid[i][col + j];
            }
            if (sum != 15) {
                return false;
            }
        }
        // check diagonal
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < 3; i++) {
            sum1 += grid[row + i][col + i];
            sum2 += grid[row + 2 - i][col + i];
        }
        if (sum1 != 15 || sum2 != 15) {
            return false;
        }

        return true;
    }
}
