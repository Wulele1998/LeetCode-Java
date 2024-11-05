package LC1275;

public class Solution {
    public String tictactoe(int[][] moves) {
        // since the size of board is 3 * 3
        // time: O(1)
        // space: O(1)
        int N = 3;
        int[][] board = new int[N][N];

        for (int i = 0; i < moves.length; i++) {
            int row = moves[i][0];
            int col = moves[i][1];
            
            if ((i & 1) == 0) {
                board[row][col] = 1;
            } else {
                board[row][col] = -1;
            }
        }

        // horizontal
        for (int i = 0; i < N; i++) {
            boolean flag = true;
            for (int j = 1; j < N; j++) {
                if (board[i][j] == 0 || board[i][j] != board[i][j - 1]) {
                    flag = false;
                    break;
                }
            }
            if (flag) 
                return board[i][0] == 1 ? "A" : "B";
        }

        // vertical
        for (int i = 0; i < N; i++) {
            boolean flag = true;
            for (int j = 1; j < N; j++) {
                if (board[j][i] == 0 || board[j][i] != board[j - 1][i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) 
                return board[0][i] == 1 ? "A" : "B";
        }

        // digonal
        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return board[0][0] == 1 ? "A" : "B";
        if (board[2][0] != 0 && board[2][0] == board[1][1] && board[1][1] == board[0][2])
            return board[2][0] == 1 ? "A" : "B";

        int count = 0;
        for (int i = 0; i < N; i++) 
            for (int j = 0; j < N; j++) 
                if (board[i][j] != 0)
                    count++;
        
        return count == 9 ? "Draw" : "Pending";
    }
}
