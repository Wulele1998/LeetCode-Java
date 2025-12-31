package LC1351;

/**
 * Dec 28, 2025
 * LC 1351. Count Negative Numbers in a Sorted Matrix
 */
public class Solution {
    public int countNegatives(int[][] grid) {
        // M: the number of rows
        // N: the number of columns
        // time: O(M + N)
        // space: O(1)
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        int negativeIndex = n - 1; // negative number index start from n

        for (int i = 0; i < m; i++) {
            while (negativeIndex >= 0 && grid[i][negativeIndex] < 0) {
                negativeIndex--;
            }

            res += n - 1 - negativeIndex;
        }

        return res;
    }
}
