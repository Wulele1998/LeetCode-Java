package LC54;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // M: the number of row
        // N: the number of column
        // time: O(M * N)
        // space: O(1)
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int left = 0, right = n - 1, up = 0, down = m - 1;
        int count = 0;

        while (count < m * n) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
                count++;
            }
            for (int i = up + 1; i <= down; i++) {
                res.add(matrix[i][right]);
                count++;
            }
            if (up != down) {
                for (int i = right - 1; i >= left; i--) {
                    res.add(matrix[down][i]);
                    count++;
                }
            }
            if (left != right) {
                for (int i = down - 1; i >= up + 1; i--) {
                    res.add(matrix[i][left]);
                    count++;
                }
            }
            up++;
            down--;
            left++;
            right--;
        }

        return res;
    }
}
