package LC1292;

/**
 * LC 1292. Maximum Side Length of a Square with Sum Less than or Equal to Threshold
 */
public class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        // M: the number of rows
        // N: the number of columns
        // time: O(M * N * max(M, N))
        // space: O(M * N)
        int m = mat.length;
        int n = mat[0].length;
        int[][] preSum = new int[m + 1][n + 1]; // padding
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + mat[i - 1][j - 1] - preSum[i - 1][ j - 1];
            }
        }

        int maxEdge = Math.min(m, n);
        for (int edge = maxEdge; edge >= 1; edge--) {
            // i + edge = m
            // i = m - edge
            for (int i = 0; i <= m - edge; i++) {
                for (int j = 0; j <= n - edge; j++) {
                    int squareSum = preSum[i + edge][j + edge] - preSum[i + edge][j] - preSum[i][j + edge] + preSum[i][j];
                    if (squareSum <= threshold) {
                        return edge;
                    }
                }
            }
        }

        return 0;
    }
}
