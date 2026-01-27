package LC490;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
    int m; // number of rows
    int n; // number of columns
    public static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public static final int WALL = 1;
    public static final int EMPTY = 0;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // edge case
        // `start` and `destination` are all valid?
        // `start` and `destination` can be at the same place?
        m = maze.length;
        n = maze[0].length;
        boolean[][][] visited = new boolean[m][n][4]; // all false in default
        Queue<int[]> queue = new LinkedList<>();

        // start from `start`
        for (int i = 0; i < 4; i++) {
            queue.add(new int[] {start[0], start[1], i});
            visited[start[0]][start[1]][i] = true;
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            // check if the ball is stop or not
            int dirIndex = current[2];
            int row = current[0] + DIRECTIONS[dirIndex][0];
            int col = current[1] + DIRECTIONS[dirIndex][1];
            if (row >= 0 && row < m && col >= 0 && col < n && maze[row][col] == EMPTY && !visited[row][col][dirIndex]) {
                queue.add(new int[] {row, col, dirIndex});
                visited[row][col][dirIndex] = true;
            } else if (row < 0 || row >= m || col < 0 || col >= n || maze[row][col] == WALL) {
                // the ball stopped
                if (current[0] == destination[0] && current[1] == destination[1]) {
                    // check if the ball has arrived at destination
                    return true;
                }

                // start choose another direction from current
                for (int i = 0; i < 4; i++) {
                    row = current[0] + DIRECTIONS[i][0];
                    col = current[1] + DIRECTIONS[i][1];
                    if (row >= 0 && row < m && col >= 0 && col < n && maze[row][col] == EMPTY && !visited[row][col][i]) {
                        queue.add(new int[] {row, col, i});
                        visited[row][col][i] = true;
                    }
                }
            }
        }

        return false;
    }
}
