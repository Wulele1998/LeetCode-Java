package LC79;

/**
 * LC 79. Word Search
 */
public class Solution {
    // M: the number of rows
    // N: the number of columns
    // L: the length of `word`
    // time: O(M * N * 3 ^ L), 3 since the word will not go back, only 3 in 4 directions are valid
    // space: O(M * N + L)
    char[][] board;
    String word;
    int COL;
    int ROW;
    int[][] DIRS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.ROW = board.length;
        this.COL = board[0].length;
        this.visited = new boolean[ROW][COL];

        // start search
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (backtrack(i, j,0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(int i, int j,int index) {
        if (index == word.length()) {
            return true;
        }

        // check the coordinate is valid and match the character
        if (i >= ROW || i < 0 || j >= COL || j < 0 || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;
        // start backtrack
        for (int[] dir : DIRS) {
            int i_ = i + dir[0];
            int j_ = j + dir[1];
            if (backtrack(i_, j_, index + 1)) {
                return true;
            }
        }

        visited[i][j] = false;
        return false;
    }
}
