package LC505;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 505. The Maze II
 */
public class Solution {
    // M: the number of rows
    // N: the number of columns
    // time: O(M * N *
    public final static int EMPTY = 0;
    public final static int WALL = 1;
    public final static int[][] DIRECTIONS = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int m; // number of rows
    int n; // number of columns
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        int[][] distance = new int[m][n]; // track the distance from `start` to cell[i][j]
        for (int i = 0; i < m; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        // BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        distance[start[0]][start[1]] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curDistance = distance[cur[0]][cur[1]];

            // roll to each direction
            for (int[] dir : DIRECTIONS) {
                int r = cur[0];
                int c = cur[1];
                int move = 0;
                while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] == EMPTY) {
                    r += dir[0];
                    c += dir[1];
                    move++;
                }

                // ball stopped
                // step back to last empty cell
                r -= dir[0];
                c -= dir[1];
                move--;

                if (distance[r][c] > curDistance + move) {
                    // cell[r][c] has shorter path from start
                    distance[r][c] = curDistance + move;
                    queue.add(new int[] {r, c});
                }
            }
        }

        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }
}
