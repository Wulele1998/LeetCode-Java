package LC37;

/**
 * LC LC 37. Sudoku Solver
 */
public class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, i, j, num)) {
                            board[i][j] = num;
                            if (backtrack(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            // search for the row and the column
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        // search for the box
        int boxRow = row / 3;
        int boxCol = col / 3;
        for (int i = boxRow * 3; i < boxRow * 3 + 3; i++) {
            for (int j = boxCol * 3; j < boxCol * 3 + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
