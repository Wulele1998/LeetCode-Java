package LC2257;

/**
 * Nov 2, 2025
 * LC 2257. Count Unguarded Cells in the Grid
 */
public class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // M: m
        // N: n
        // G: number of guards
        // W: number of walls
        // time: O(G + W + G(M + N) + M * N) = O(G * (M + N) + M * N)
        // space: O(M * N)
        int[][] grid = new int[m][n];
        int res = 0;

        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 2;
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = -1;
        }

        for (int[] guard : guards) {
            int row = guard[0];
            int col = guard[1];
            // go left direction
            for (int c = col - 1; c >= 0; c--) {
                if (grid[row][c] == 0 || grid[row][c] == 1) {
                    grid[row][c] = 1; // mark as visited
                } else {
                    // meet a guard or wall
                    break;
                }
            }

            // go right direction
            for (int c = col + 1; c < n; c++) {
                if (grid[row][c] == 0 || grid[row][c] == 1) {
                    grid[row][c] = 1; // mark as visited
                } else {
                    // meet a guard or wall
                    break;
                }
            }

            // go up direction
            for (int r = row - 1; r >= 0; r--) {
                if (grid[r][col] == 0 || grid[r][col] == 1) {
                    grid[r][col] = 1;
                } else {
                    break;
                }
            }

            // go down direction
            for (int r = row + 1; r < m; r++) {
                if (grid[r][col] == 0 || grid[r][col] == 1) {
                    grid[r][col] = 1;
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res++;
                }
            }
        }

        return res;
    }
}
