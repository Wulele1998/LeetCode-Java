package LC329;

/**
 * LC 329. Longest Increasing Path in a Matrix
 */
public class Solution2 {
    final static int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m;
    private int n;
    private int[][] memo;
    public int longestIncreasingPath(int[][] matrix) {
        // M: the number of row
        // N: the number of column
        // time: O(M * N), each cell will be calculated once
        // space: O(M * N)
        m = matrix.length;
        n = matrix[0].length;
        memo = new int[m][n]; // using memo to avoid duplicate calculation
        int longestPath = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                longestPath = Math.max(longestPath, DFS(matrix, i, j));
            }
        }

        return longestPath;
    }

    private int DFS(int[][] matrix, int i, int j) {
        if (memo[i][j] != 0)
            return memo[i][j];
        int maxLength = 0;
        for (int[] d : DIRECTIONS) {
            int r = i + d[0];
            int c = j + d[1];
            if (r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] > matrix[i][j]) {
                maxLength = Math.max(maxLength, DFS(matrix, r, c));
            }
        }
        return memo[i][j] = maxLength + 1;
    }
}
