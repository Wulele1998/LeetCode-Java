package LC2577;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int minimumTime(int[][] grid) {
        // Dijkstra
        // corner case
        // cannot arrive the target
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        int m = grid.length;
        int n = grid[0].length;
        final int[][] DIRS = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        boolean[][] visited = new boolean[m][n];
        // [time, row, col]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        pq.offer(new int[] { grid[0][0], 0, 0 });
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int time = cur[0], row = cur[1], col = cur[2];

            // arrive the destination
            if (row == m - 1 && col == n - 1) {
                return time;
            }

            if (visited[row][col]) {
                continue;
            }
            visited[row][col] = true;

            for (int[] dir : DIRS) {
                int r = row + dir[0];
                int c = col + dir[1];

                if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c]) {
                    int wait = ((grid[r][c] - time) % 2 == 0) ? 1 : 0;
                    pq.offer(new int[] { Math.max(grid[r][c] + wait, time + 1), r, c });
                }
            }
        }

        return -1;
    }
}
