package LC1642;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        Queue<Integer> gaps = new PriorityQueue<>((a, b) -> a - b);
        for (int i = 0; i < heights.length - 1; i++) {
            int climb = heights[i + 1] - heights[i];
            if (climb <= 0)
                continue;

            gaps.add(climb);
            if (gaps.size() <= ladders) {
                continue;
            }
            bricks -= gaps.remove();
            if (bricks < 0) {
                return i;
            }
        }

        return heights.length - 1;
    }
}
