package LC505;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 505. The Maze II
 */
public class Solution2 {
    // M: the number of rows
    // N: the number of columns
    public final static int EMPTY = 0;
    public final static int WALL = 1;
    public final static int[][] DIRECTIONS = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int[][] distance;
    int m; // number of rows
    int n; // number of columns
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        distance = new int[m][n]; // track the distance from `start` to cell[i][j]
        for (int i = 0; i < m; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        DFS(maze, start[0], start[1], 0);

        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }

    private void DFS(int[][] maze, int row, int col, int move) {
        distance[row][col] = move;

        for (int[] dir : DIRECTIONS) {
            int r = row;
            int c = col;
            int count = 0;
            while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] == EMPTY) {
                r += dir[0];
                c += dir[1];
                count++;
            }

            // step back
            r -= dir[0];
            c -= dir[1];
            count--;

            if (distance[r][c] > count + move) {
                distance[r][c] = count + move;
                DFS(maze, r, c, distance[r][c]);
            }
        }
    }
}

