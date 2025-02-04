package LC1765;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 1765. Map of Highest Peak
 */
public class Solution2 {
    public int[][] highestPeak(int[][] isWater) {
        // DP from Top-Left and bottom-right
        // M: the number of rows
        // N: the number of columns
        // time: O(M * N)
        // complexity: O(1)
        final int MAX_HEIGHT = 2000;
        int m = isWater.length;
        int n = isWater[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    isWater[i][j] = 0;
                } else {
                    isWater[i][j] = 1;
                }
            }
        }

        // DP from top-left to bottom-right
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // find the land cell
                if (isWater[i][j] != 0) {
                    int upperHeight = i - 1 >= 0 ? isWater[i - 1][j] : MAX_HEIGHT;
                    int leftHeight = j - 1 >= 0 ? isWater[i][j - 1] : MAX_HEIGHT;
                    isWater[i][j] = Math.min(upperHeight, leftHeight) + 1;
                }
            }
        }
        System.out.println("DP 1");
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(isWater[i]));
        }

        // DP from bottom-right to top-left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (isWater[i][j] != 0) {
                    int bottomHeight = i + 1 < m ? isWater[i + 1][j] : MAX_HEIGHT;
                    int rightHeight = j + 1 < n ? isWater[i][j + 1] : MAX_HEIGHT;
                    isWater[i][j] = Math.min(isWater[i][j], Math.min(bottomHeight, rightHeight) + 1);
                }
            }
        }

        System.out.println("DP 2");
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(isWater[i]));
        }


        return isWater;
    }
}
