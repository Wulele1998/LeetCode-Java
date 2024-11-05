package LC3047;

/**
 * LC 3047. Find the Largest Area of Square Inside Two Rectangles
 */
public class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        // N: the length of `bottomLeft` and `topRight`
        // time: O(N ^ 2)
        // space: O(1)
        int n = bottomLeft.length;
        long square = 0L;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int ax1 = bottomLeft[i][0];
                int ay1 = bottomLeft[i][1];
                int ax2 = topRight[i][0];
                int ay2 = topRight[i][1];
                int bx1 = bottomLeft[j][0];
                int by1 = bottomLeft[j][1];
                int bx2 = topRight[j][0];
                int by2 = topRight[j][1];
                int deltaX = Math.min(ax2, bx2) - Math.max(ax1, bx1);
                int deltaY = Math.min(ay2, by2) - Math.max(ay1, by1);
                if (deltaX > 0 && deltaY > 0) {
                    long len = Math.min(deltaX, deltaY);
                    square = Math.max(square,  len * len);
                }
            }
        }

        return square;
    }
}
