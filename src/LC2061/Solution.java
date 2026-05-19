package LC2061;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // right => down => left => up (clockwise)
    public static final int[][] DIRECTIONS = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static final int OBJECT = 1;
    public static final int EMPTY = 0;
    public static final int CLEANED = -1;

    // M: the number of rows
    // N: the number of columns
    // time: O(M * N)
    // space: O(M * N)
    public int numberOfCleanRooms(int[][] room) {
        // edge case, the room 2-D array is empty
        if (room == null || room.length == 0 || room[0].length == 0) {
            return 0;
        }

        int m = room.length; // the number of rows
        int n = room[0].length; // the number of columns
        int count = 0;
        boolean[][][] visited = new boolean[m][n][4]; // each cell, 4 directions, default be false
        // {row, col, directionIndex}
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, 0});
        visited[0][0][0] = true;
        room[0][0] = CLEANED;
        count++;

        // BFS
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0], col = cur[1], dirIndex = cur[2];

            // the cleaning robot will move forward to current direction until it reach the border or object
            int nextRow = row + DIRECTIONS[dirIndex][0];
            int nextCol = col + DIRECTIONS[dirIndex][1];
            while (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && room[nextRow][nextCol] != OBJECT) {
                if (room[nextRow][nextCol] == EMPTY) {
                    room[nextRow][nextCol] = CLEANED;
                    count++;
                }
                nextRow += DIRECTIONS[dirIndex][0];
                nextCol += DIRECTIONS[dirIndex][1];
            }

            // now room[nextRow][nextCol] is in a invalid room (out of index or at an object cell)
            // move one step back
            nextRow -= DIRECTIONS[dirIndex][0];
            nextCol -= DIRECTIONS[dirIndex][1];
            // turn 90 degree clockwise to start next search
            dirIndex = (dirIndex + 1) % 4;
            if (!visited[nextRow][nextCol][dirIndex]) {
                visited[nextRow][nextCol][dirIndex] = true;
                queue.offer(new int[] {nextRow, nextCol, dirIndex});
            }
        }

        return count;
    }
}
