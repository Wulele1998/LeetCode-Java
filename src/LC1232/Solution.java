package LC1232;

public class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        // N: the length of `coordinates`
        // time: O(N)
        // space: O(1)
        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];
        int dx = x1 - x0;
        int dy = y1 - y0;

        // dx / dx_ = dy / dy_ 
        // in case of the dividor cannot be 0, dx * dy_ = dx_ * dy
        for (int i = 2; i < coordinates.length; i++) {
            int dx_ = coordinates[i][0] - x0;
            int dy_ = coordinates[i][1] - y0;
            if (dx * dy_ != dx_ * dy)
                return false;
        }

        return true;
    }
}
