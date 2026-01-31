package LC499;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * LC 499. The Maze III
 */
class Cell {
    int row;
    int col;
    int distance;
    String path;

    public Cell(int row, int col, int distance, String path) {
        this.row = row;
        this.col = col;
        this.distance = distance;
        this.path = path;
    }
}

public class Solution {
    public static final int[][] DIRECTIONS = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    public static final String[] DIR_STRS = new String[] {"l", "u", "r", "d"};
    public static final int WALL = 1;
    public static final int EMPTY = 0;
    int m; // number of rows
    int n; // number of columns

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        // Dijkstra
        m = maze.length;
        n = maze[0].length;
        int[][] res = new int[m][n]; // save the distance from ball to all cells
        for (int i = 0; i < m; i++) {
            Arrays.fill(res[i], Integer.MAX_VALUE); // initialize
        }

        PriorityQueue<Cell> minHeap = new PriorityQueue<>((o1, o2) -> {
            if (o1.distance == o2.distance) {
                return o1.path.compareTo(o2.path); // lexicographically
            }
            return o1.distance - o2.distance;
        });

        minHeap.add(new Cell(ball[0], ball[1], 0, ""));
        boolean[][] visited = new boolean[m][n];

        while (!minHeap.isEmpty()) {
            Cell current = minHeap.poll();
            // arrive at the hole 
            if (current.row == hole[0] && current.col == hole[1]) {
                return current.path;
            }
            if (visited[current.row][current.col]) {
                continue;
            }
            visited[current.row][current.col] = true;
            
            for (int i = 0; i < 4; i++) {
                int row = current.row;
                int col = current.col;
                int distance = current.distance;
                String path = current.path;
                int[] dir = DIRECTIONS[i];
                
                // start rolling
                int count = 0;
                boolean meetHole = false;
                while (row >= 0 && row < m && col >= 0 && col < n && maze[row][col] == EMPTY) {
                    row += dir[0];
                    col += dir[1];
                    count++;
                    if (row == hole[0] && col == hole[1]) {
                        minHeap.add(new Cell(row, col, count + distance, path + DIR_STRS[i]));
                        meetHole = true;
                        break;
                    }
                }
                if (!meetHole) {
                    // stop at the wall cell
                    // moce one step back to the last valid cell
                    row -= dir[0];
                    col -= dir[1];
                    count--;
                    // Dijkstra relax operation
                    minHeap.add(new Cell(row, col, distance + count, path + DIR_STRS[i]));
                }
            }
        }

        return "impossible";
    }
}