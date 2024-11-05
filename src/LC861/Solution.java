package LC861;

/**
 * LC 861. Score After Flipping Matrix
 */
public class Solution {
    public int matrixScore(int[][] grid) {
        // M: the number of rows in the `grid`  
        // N: the number of columns in the `grid`
        // time: O(M * N)
        // space: O(1)
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                // toggle
                for (int j = 0; j < n; j++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }

        for (int j = 1; j < n; j++) {
            int countZero = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 0) {
                    countZero++;
                }
            }

            if (countZero > m - countZero) {
                // the number of 0 is larger than 1, toggle
                for (int i = 0; i < m; i++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            int score = 0;
            for (int j = 0; j < n; j++) {
                score += grid[i][j] << (n - j - 1);
            }

            res += score;
        }

        return res;
    }
}
