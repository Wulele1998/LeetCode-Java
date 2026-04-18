package LC417;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    // BFS
    // M: the number of rows
    // N: the number of columns
    // time: O(M * N)
    // space: O(M * N)
    public static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int[][] count;
    private int m; // row number
    private int n; // column number
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights.length == 0 || heights[0].length == 0) {
            return res; // edge case
        }

        m = heights.length;
        n = heights[0].length;
        count = new int[m][n];
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            pacificQueue.offer(new int[] {i, 0});
            atlanticQueue.offer(new int[] {i, n - 1});
        }

        for (int j = 0; j < n; j++) {
            if (j > 0)
                pacificQueue.offer(new int[] {0, j});
            if (j < n - 1)
                atlanticQueue.offer(new int[] {m - 1, j});
        }

        bfs(pacificQueue, heights);
        bfs(atlanticQueue, heights);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (count[i][j] >= 2) {
                    res.add(List.of(i, j));
                }
            }
        }

        return res;
    }

    private void bfs(Queue<int[]> queue, int[][] heights) {
        boolean[][] visited = new boolean[m][n];
        for (int[] cell : queue) {
            visited[cell[0]][cell[1]] = true;
            count[cell[0]][cell[1]]++;
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] d : DIRECTIONS) {
                int r = cur[0] + d[0];
                int c = cur[1] + d[1];
                if (r >= 0 && r < m && c >= 0 && c < n && heights[cur[0]][cur[1]] <= heights[r][c] && !visited[r][c]) {
                    queue.add(new int[] {r, c});
                    visited[r][c] = true;
                    count[r][c]++;
                }
            }
        }
    }
}
