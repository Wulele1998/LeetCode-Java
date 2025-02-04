package LC1266;

public class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        // N: the length of `points`
        // time: O(N)
        // space: O(1)
        int res = 0;

        for (int i = 1; i < points.length; i++) {
            res += Math.max(Math.abs(points[i][0] - points[i - 1][0]), Math.abs(points[i][1] - points[i - 1][1]));
        }

        return res;
    }
}
