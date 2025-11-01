package LC37;

/**
 * LC 37. Sudoku Solver
 */
public class Solution2 {
    boolean[][] rows = new boolean[9][9];
    boolean[][] cols = new boolean[9][9];
    boolean[][] boxes = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[boxIndex(i, j)][num] = true;
                }
            }
        }

        backtrack(board, 0, 0);

    }

    private int boxIndex(int i, int j) {
        return (i / 3) * 3 + (j / 3);
    }

    private boolean backtrack(char[][] board, int curRow, int curCol) {
        if (curRow == 9) {
            // reach to the end
            return true;
        }
        if (curCol == 9) {
            // reach to the end of the row, move to next row
            return backtrack(board, curRow + 1, 0);
        }
        if (board[curRow][curCol] != '.') {
            // move to next cell
            return backtrack(board, curRow, curCol + 1);
        }
        // try to fill the cell
        for (int i = 0; i < 9; i++) {
            if (!rows[curRow][i] && !cols[curCol][i] && !boxes[boxIndex(curRow, curCol)][i]) {
                board[curRow][curCol] = (char) (i + '1');
                rows[curRow][i] = true;
                cols[curCol][i] = true;
                boxes[boxIndex(curRow, curCol)][i] = true;

                if (backtrack(board, curRow, curCol + 1)) {
                    return true;
                }

                // restore the previous status
                rows[curRow][i] = false;
                cols[curCol][i] = false;
                boxes[boxIndex(curRow, curCol)][i] = false;
                board[curRow][curCol] = '.';
            }
        }

        return false; // cannot find the solution
    }
}
