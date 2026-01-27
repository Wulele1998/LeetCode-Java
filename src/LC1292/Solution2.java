package LC1292;

/**
 * LC 1292. Maximum Side Length of a Square with Sum Less than or Equal to Threshold
 */
public class Solution2 {
    int m;
    int n;
    public int maxSideLength(int[][] mat, int threshold) {
        // M: the number of rows
        // N: the number of columns
        // time: O(M * N * log(min(M, N)))
        // space: O(M * N)
        m = mat.length;
        n = mat[0].length;
        int[][] preSum = new int[m + 1][n + 1]; // padding
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + mat[i - 1][j - 1] - preSum[i - 1][ j - 1];
            }
        }

        // using binary search
        int maxEdge = Math.min(m, n);
        int minEdge = 1;
        int left = minEdge, right = maxEdge;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canFindValidSquare(preSum, mid, threshold)) {
                // make the edge larger
                left = mid + 1;
                res = mid;
            } else {
                // make the edge smaller
                right = mid - 1;
            }
        }

        return res;
    }

    private boolean canFindValidSquare(int[][] preSum, int edge, int threshold) {
        for (int i = 0; i <= m - edge; i++) {
            for (int j = 0; j <= n - edge; j++) {
                int squareSum = preSum[i + edge][j + edge] - preSum[i + edge][j] - preSum[i][j + edge] + preSum[i][j];
                if (squareSum <= threshold) {
                    return true;
                }
            }
        }

        return false;
    }
}
