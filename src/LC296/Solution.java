package LC296;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int minTotalDistance(int[][] grid) {
        // M: the number row
        // N: the number of column
        // time: O(M * N log (M * N))
        // space: O(M * N), list space at most for M * N points
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols  = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        int medianRow = rows.get(rows.size() / 2);
        Collections.sort(cols);
        int medianCol = cols.get(cols.size() / 2);
        
        for (int row : rows) {
            res += Math.abs(medianRow - row);
        }
        for (int col : cols) {
            res += Math.abs(medianCol - col);
        }

        return res;
    }
}
