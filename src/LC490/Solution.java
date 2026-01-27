package LC490;

/**
 * LC 490. The Maze
 */
public class Solution {
    public static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public static final int WALL = 1;
    public static final int EMPTY = 0;
    int m; // number of rows
    int n; // number of columns
    boolean[][] visited;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // M: the number of rows in `maze`
        // N: the number of columns in `maze`
        // time: O(M * N * (M + N)
        // space: O(M * N)
        // edge case
        // `start` and `destination` are all valid?
        // `start` and `destination` can be at the same place?
        m = maze.length;
        n = maze[0].length;
        visited = new boolean[m][n]; // all false in default

        return DFS(maze, start[0], start[1], destination);

    }

    private boolean DFS(int[][] maze, int row, int col, int[] destination) {
        if (row == destination[0] && col == destination[1]) {
            return true;
        }

        visited[row][col] = true; // mark as visited
        for (int[] dir : DIRECTIONS) {
            int r = row + dir[0];
            int c = col + dir[1];

            while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] == EMPTY) {
                r += dir[0];
                c += dir[1]; // keep rolling until hit the wall or out of scope
            }

            // move back to the last empty cell as the end of current direction
            r -= dir[0];
            c -= dir[1];

            if (!visited[r][c]) {
                if (DFS(maze, r, c, destination)) {
                    return true;
                }
            }
        }

        return false;
    }
}
