package LC827;

import java.util.HashMap;
import java.util.HashSet;

public class Solution2 {
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
                    int islandSize = islandSizeDFS(grid, m, n, i, j, id);
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
