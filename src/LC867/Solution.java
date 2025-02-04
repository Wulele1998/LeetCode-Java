package LC867;

public class Solution {
    public int[][] transpose(int[][] matrix) {
        // M: the row number
        // N: the column number
        // time: O(M * N)
        // space: O(M * N)
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][i] = matrix[i][j];
            }
        }

        return res;
    }
}
