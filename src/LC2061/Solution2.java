package LC2061;

public class Solution2 {
    // right => down => left => up (clockwise)
    public static final int[][] DIRECTIONS = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static final int OBJECT = 1;
    public static final int EMPTY = 0;
    public static final int CLEANED = -1;

    private int m; // number of rows
    private int n; // number of columns
    private int count;
    private boolean[][][] visited;

    public int numberOfCleanRooms(int[][] room) {
        // edge case: the room is empty
        if (room == null || room.length == 0 || room[0].length == 0) {
            return 0;
        }

        m = room.length;
        n = room[0].length;
        count = 0;
        visited = new boolean[m][n][4];

        dfsHelper(room, 0, 0, 0);

        return count;
    }

    private void dfsHelper(int[][]room, int row, int col, int directIndex) {
        // current cell room[row][col]
        visited[row][col][directIndex] = true;
        // move all cells in current direction until move out of index or hit the object
        int nextRow = row;
        int nextCol = col;
        while (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && room[nextRow][nextCol] != OBJECT) {
            if (room[nextRow][nextCol] == EMPTY) {
                room[nextRow][nextCol] = CLEANED;
                count++;
            }
            nextRow += DIRECTIONS[directIndex][0];
            nextCol += DIRECTIONS[directIndex][1];
        }

        // hit the border or object
        nextRow -= DIRECTIONS[directIndex][0];
        nextCol -= DIRECTIONS[directIndex][1];
        // turn 90 degree clockwise and start new path
        directIndex = (directIndex + 1) % 4;
        if (!visited[nextRow][nextCol][directIndex]) {
            dfsHelper(room, nextRow, nextCol, directIndex);
        }
    }
}
