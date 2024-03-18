package LC452;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (Comparator.comparingInt(o -> o[0])));
        int end = points[0][1];
        int arrow = 1;
        for (int[] point : points) {
            if (point[0] > end) {
                arrow++;
                end = point[1];
            }
        }

        return arrow;
    }
}
