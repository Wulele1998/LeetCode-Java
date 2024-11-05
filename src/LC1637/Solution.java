package LC1637;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        // N: the length of `points`
        // time: O(N * log N)
        // space: O(log N), the space use for quick sort
        Arrays.sort(points, Comparator.comparingInt(pointA -> pointA[0]));
        int maxDis = 0;
        int n = points.length;

        for (int i = 0; i < n - 1; i++) {
            maxDis = Math.max(maxDis, Math.abs(points[i][0] - points[i + 1][0]));
        }

        return maxDis;
    }
}
