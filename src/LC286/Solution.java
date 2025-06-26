package LC286;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 286. Walls and Gates
 */
public class Solution {
    // BFS
    // time: O(M * N)
    // space: O(M * N)
    public void wallsAndGates(int[][] rooms) {
        final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        final int GATE = 0;
        final int WALL = -1;
        final int EMPTY = Integer.MAX_VALUE;
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == GATE) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for (int[] direction : DIRECTIONS) {
                    int x = cell[0] + direction[0];
                    int y = cell[1] + direction[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && rooms[x][y] == EMPTY) {
                        rooms[x][y] = distance;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}
