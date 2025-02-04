package LC54;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int count = 0;
        int round = 0;

        while (count < m * n) {
            int left = round, up = round, right = n - 1 - round, down = m - 1 - round;
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
            
            round++;
        }

        return res;
    }
}
