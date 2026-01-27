package LC490;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    int m; // number of rows
    int n; // number of columns
    public static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public static final int WALL = 1;
    public static final int EMPTY = 0;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // edge case
        // M: the number of rows in `maze`
        // N: the number of columns in `maze`
        // time: O(M * N * (M + N)
        // space: O(M * N)
        // `start` and `destination` are all valid?
        // `start` and `destination` can be at the same place?
        m = maze.length;
        n = maze[0].length;
        boolean[][] visited = new boolean[m][n]; // all false in default
        Queue<int[]> queue = new LinkedList<>();

        // start from `start` BFS
        queue.add(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (current[0] == destination[0] && current[1] == destination[1]) {
                // arrive at destination
                return true;
            }
            for (int[] dir : DIRECTIONS) {
                // keep rolling
                int row = current[0] + dir[0];
                int col = current[1] + dir[1];
                while (row >= 0 && row < m && col >= 0 && col < n && maze[row][col] == EMPTY) {
                    // if the next cell in this direction is valid
                    row += dir[0];
                    col += dir[1];
                }
                // stopped in an in-valid space, wall or out of maze
                // move back
                row -= dir[0];
                col -= dir[1]; // the end of rolling in current space
                if (!visited[row][col]) {
                    queue.add(new int[] {row, col});
                    visited[row][col] = true;
                }
            }
        }

        return false;
    }
}
