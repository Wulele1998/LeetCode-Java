package LC221;

import java.util.Arrays;

/**
 * LC 221. Maximal Square
 */
public class Solution2 {
    // Dynamic Programming, top-down
    // M: the number of rows
    // N: the number of columns
    // time: O(M * N)
    // space: O(M * N)
    int col;
    int row;
    int[][] memo;
    int res = 0;

    public int maximalSquare(char[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        memo = new int[row][col];

        // initialize the `memo`
        for (int i = 0; i < row; i++) {
            Arrays.fill(memo[i], -1);
        }

        DP(matrix, row - 1, col - 1);
        return res * res;
    }

    /**
     * get edge length of the largest square from [0, 0] to [i][j]
     * @param matrix the matrix
     * @param i the row index
     * @param j the column index
     * @return the edge length of the larget square
     */

    private int DP(char[][] matrix, int i, int j) {
        if (i < 0 || j < 0) { // base case
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int minAdj = Math.min(DP(matrix, i - 1, j - 1), Math.min(DP(matrix, i - 1, j), DP(matrix, i, j - 1)));

        if (matrix[i][j] == '0') {
            memo[i][j] = 0;
        } else {
            memo[i][j] = minAdj + 1;
            res = Math.max(res, memo[i][j]);
        }

        return memo[i][j];
    }
}
