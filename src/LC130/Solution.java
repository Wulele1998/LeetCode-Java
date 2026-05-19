package LC130;

import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    public static final char MARK_X = 'X';
    public static final char MARK_O = 'O';
    public static final char ALIVE_O = '#';
    public static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private Queue<int[]> queue;
    private int m;
    private int n;

    public void solve(char[][] board) {
        // edge case: the board is empty
        if (board.length == 0 || board[0].length == 0) {
            return;
        }

        m = board.length; // number of rows
        n = board[0].length; // number of columns

        queue = new LinkedList<>();
        addAllOInBorder(board);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] d : DIRECTIONS) {
                    int nextR = cur[0] + d[0];
                    int nextC = cur[1] + d[1];
                    if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && board[nextR][nextC] == MARK_O) {
                        queue.offer(new int[] {nextR, nextC});
                        board[nextR][nextC] = ALIVE_O;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == ALIVE_O) {
                    board[i][j] = MARK_O;
                } else {
                    board[i][j] = MARK_X;
                }
            }
        }

    }

    public void addAllOInBorder(char[][] board) {
        for (int i = 0; i < m; i++) {
            if (board[i][0] == MARK_O) {
                queue.offer(new int[] {i, 0});
                board[i][0] = ALIVE_O;
            }
            if (n - 1 > 0 && board[i][n - 1] == MARK_O) {
                queue.offer(new int[] {i, n - 1});
                board[i][n - 1] = ALIVE_O;
            }
        }

        for (int j = 1; j < n - 1; j++) {
            if (board[0][j] == MARK_O) {
                queue.offer(new int[] {0, j});
                board[0][j] = ALIVE_O;
            }
            if (m - 1 > 0 && board[m - 1][j] == MARK_O) {
                queue.offer(new int[] {m - 1, j});
                board[m - 1][j] = ALIVE_O;
            }
        }
    }
}
