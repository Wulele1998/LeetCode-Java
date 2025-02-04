package LC1992;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LC 1992. Find All Groups of Farmland
 */
public class Solution {
    public int[][] findFarmland(int[][] land) {
        // M: the number of rows
        // N: the number of columns
        // time: O(M * N)
        // space: O(M * N)
        int m = land.length;
        int n = land[0].length;
        int[][] dirs = new int[][] {{0, 1}, {1, 0}};
        List<int[]> list = new ArrayList<>();

        // BFS
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    land[i][j] = -1;
                    int[] farm = new int[4];
                    farm[0] = i;
                    farm[1] = j;

                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[] {i, j});
                    int maxX = i;
                    int maxY = j;
                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        for (int[] dir : dirs) {
                            int x = poll[0] + dir[0];
                            int y = poll[1] + dir[1];
                            if (x >= 0 && x < m && y >= 0 && y < n && land[x][y] == 1) {
                                land[x][y] = -1;
                                queue.add(new int[] {x, y});
                                maxX = Math.max(x, maxX);
                                maxY = Math.max(y, maxY);
                            }
                        }
                    }
                    farm[2] = maxX;
                    farm[3] = maxY;
                    list.add(farm);
                }
            }
        }
        int[][] res = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
