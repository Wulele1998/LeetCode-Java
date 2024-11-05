package LC73;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public void setZeroes(int[][] matrix) {
        // `matrix`: M * N
        // time: O(M * N)
        // space: O(M + N)
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for (int r : row) {
            for (int j = 0; j < n; j++) {
                matrix[r][j] = 0;
            }
        }

        for (int c : col) {
            for (int i = 0; i < m; i++) {
                matrix[i][c] = 0;
            }
        }
    }
}
