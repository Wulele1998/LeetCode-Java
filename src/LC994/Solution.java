package LC994;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static final int EMPTY = 0;
    public static final int FRESH = 1;
    public static final int ROTTEN = 2;
    public static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        // edge case
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        Queue<int[]> rottenQueue = new LinkedList<>(); // saving the coordinates of rotten oranges
        int m = grid.length; // the number of rows
        int n = grid[0].length; // the number of columns
        int freshCount = 0; // count the number of fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == ROTTEN) {
                    rottenQueue.offer(new int[] {i, j});
                } else if (grid[i][j] == FRESH) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) {
            return 0;
        }

        int day = 0;
        while (!rottenQueue.isEmpty()) {
            int size = rottenQueue.size();
            day++;
            for (int i = 0; i < size; i++) {
                int[] cur = rottenQueue.poll();
                for (int[] d : DIRECTIONS) {
                    int nextR = cur[0] + d[0];
                    int nextC = cur[1] + d[1];
                    if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && grid[nextR][nextC] == FRESH) {
                        grid[nextR][nextC] = ROTTEN;
                        rottenQueue.offer(new int[] {nextR, nextC});
                        freshCount--;
                        if (freshCount == 0) {
                            return day;
                        }
                    }
                }
            }
        }

        return -1;
    }
}
