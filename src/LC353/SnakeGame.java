package LC353;

import java.util.*;

public class SnakeGame {
    Queue<int[]> body;
    Queue<int[]> foodQueue;
    HashSet<String> bodyCells;
    int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    HashMap<String, Integer> map;
    int[] head;
    int score = 0;
    int height;
    int width;

    public SnakeGame(int width, int height, int[][] food) {
        this.body = new LinkedList<>();
        this.foodQueue = new LinkedList<>();
        this.bodyCells = new HashSet<>();
        this.head = new int[] {0, 0};
        this.map = new HashMap<>();
        this.height = height;
        this.width = width;

        foodQueue.addAll(Arrays.asList(food));

        body.add(head); // snake starts from (0. 0)
        bodyCells.add(pointToString(head));

        map.put("R", 0);
        map.put("D", 1);
        map.put("L", 2);
        map.put("U", 3);
    }

    public int move(String direction) {
        int x = DIRS[map.get(direction)][0] + head[0];
        int y = DIRS[map.get(direction)][1] + head[1];

        // hit the wall
        if (x < 0 || x >= height || y < 0 || y >= width) {
            return -1;
        }

        int[] curCell = new int[] {x, y};

        if (!foodQueue.isEmpty() && x == foodQueue.peek()[0] && y == foodQueue.peek()[1]) {
            foodQueue.poll();
            score++;
        } else {
            int[] pastCell = body.poll();
            bodyCells.remove(pointToString(pastCell));

            // hit the body
            if (bodyCells.contains(pointToString(curCell))) {
                return -1;
            }
        }
        body.add(curCell);
        bodyCells.add(pointToString(curCell));
        head = curCell;


        return score;
    }

    private String pointToString(int[] node) {
        StringBuilder sb = new StringBuilder();
        sb.append(node[0]);
        sb.append(",");
        sb.append(node[1]);

        return sb.toString();
    }
}
