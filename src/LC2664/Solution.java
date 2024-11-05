package LC2664;

/**
 * LC 2664. The Knight's Tour
 */
public class Solution {
    int[][] directions = new int[][] {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
    public int[][] tourOfKnight(int m, int n, int r, int c) {
        // backtrack
        int[][] chess = new int[m][n];

        chess[r][c] = -1;
        chessTour(r, c, chess, 1);
        chess[r][c] = 0;

        return chess;
    }


    private boolean chessTour(int curRow, int curCol, int[][] chess, int step) {
        int m = chess.length;
        int n = chess[0].length;

        if (step == m * n)
            return true;

        for (int[] dir : directions) {
            int row = curRow + dir[0];
            int col = curCol + dir[1];
            if (row >= 0 && row < m && col >= 0 && col < n && chess[row][col] == 0) {
               chess[row][col] = step;
               if (chessTour(row, col, chess, step + 1)) {
                   return true;
               }

               // backtrack
               chess[row][col] = 0;
            }
        }

        return false;
    }
}
