package LC827;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 827. Making A Large Island
 */
public class Solution {
    final int[][] DIRECTIONS = {{0, 1},{1, 0},{0, -1},{-1, 0}};
    public int largestIsland(int[][] grid) {
        // M: the number of rows
        // N: the number of columns
        // time: O(M * N)
        // space: O(M * N)
        // island id -> island size
        HashMap<Integer, Integer> idToSize = new HashMap<>();
        int maxIsland = 1;
        int m = grid.length;
        int n = grid[0].length;
        int id = 2; // id start from 2

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // BFS / DFS find all islands and marked them using id
                    int islandSize = islandSizeBFS(grid, m, n, i, j, id);
                    maxIsland = Math.max(maxIsland, islandSize);
                    idToSize.put(id++, islandSize);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    // search if there are any island in its neighbor
                    HashSet<Integer> nearbyIslands = new HashSet<>();
                    int size = 1;
                    for (int[] direction : DIRECTIONS) {
                        int r = i + direction[0];
                        int c = j + direction[1];
                        if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] != 0) {
                            nearbyIslands.add(grid[r][c]);
                        }
                    }
                    for (int islandId : nearbyIslands) {
                        size += idToSize.get(islandId);
                    }
                    maxIsland = Math.max(maxIsland, size);
                }
            }
        }
        return maxIsland;
    }

    private int islandSizeBFS(int[][] grid, int m, int n, int i, int j, int id) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        grid[i][j] = id; // mark as visited using current island id
        int size = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] direction : DIRECTIONS) {
                int r = cur[0] + direction[0];
                int c = cur[1] + direction[1];
                if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
                    grid[r][c] = id;
                    size++;
                    queue.add(new int[] {r, c});
                }
            }
        }

        return size;
    }

    private int islandSizeDFS(int[][] grid, int m, int n, int i, int j, int id) {
        int size = 1;
        grid[i][j] = id; // mark as visited
        for (int[] direction : DIRECTIONS) {
            int r = i + direction[0];
            int c = j + direction[1];
            if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
                size += islandSizeDFS(grid, m, n, r, c, id);
            }
        }

        return size;
    }
}
