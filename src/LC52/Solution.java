package LC52;

import java.util.Arrays;

public class Solution {
    private int res;
    public int totalNQueens(int n) {
        res = 0;
        char[][] board = new char[n][n];
        // initialize the board
        for (char[] rowArray : board) {
            Arrays.fill(rowArray, '.');
        }

        backtrackHelper(n, 0, board);

        return res;
    }

    /**
     * backtrack helper recursion fucntion that find the place to put the queen at the current row
     * @param n the number of queen we have totally, N queen problem
     * @param row the row that we are currently trying to find the place to put the queen
     * @param board the board that saves current state
     */
    private void backtrackHelper(int n, int row, char[][] board) {
        // base case: we reach the end of the row of the board, we completed one solution for N queen
        if (row == n) {
            res++;
            return;
        }

        // find the column that the queen can be put at board[row][col]
        for (int col = 0; col < n; col++) {
            if (isValidQueen(n, row, col, board)) {
                board[row][col] = 'Q';
                // keep moving to next row for current solution
                backtrackHelper(n, row + 1, board);

                // backtrack to previous state (revoke the queen we put) for next loop
                board[row][col] = '.';
            }
        }
    }

    /**
     * whether the queen is valid to be put at board[row][col]
     * @param n the size of the board
     * @param row the row number of current cell we will put the queen
     * @param col the column number of current cell we will put the queen
     * @param board the board stores the current state
     * @return true - valid, false - invalid
     */
    private boolean isValidQueen(int n, int row, int col, char[][] board) {
        // check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q')
                return false;
        }

        // check top-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }

        return true;
    }
}
