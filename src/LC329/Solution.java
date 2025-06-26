package LC329;

public class Solution {
    final static int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m;
    private int n;
    public int longestIncreasingPath(int[][] matrix) {
        // brute force DFS
        // M: the number of rows
        // N: the number of columns
        // time: O(4 ^ (M * N))
        m = matrix.length;
        n = matrix[0].length;
        int longestPath = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                longestPath = Math.max(longestPath, dfs(matrix, i, j));
            }
        }

        return longestPath;
    }

    private int dfs(int[][] matrix, int row, int col) {
        int len = 0;
        for (int[] dir : DIRECTIONS) {
            int r = row + dir[0];
            int c = col + dir[1];
            if (r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] > matrix[row][col]) {
                len = Math.max(len, dfs(matrix, r, c));
            }
        }

        return len + 1;
    }
}
