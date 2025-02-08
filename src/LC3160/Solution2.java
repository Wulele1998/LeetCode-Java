package LC3160;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 3160. Find the Number of Distinct Colors Among the Balls
 */
public class Solution2 {
    public int[] queryResults(int limit, int[][] queries) {
        // N: the number of `queries`
        // M: the number of balls
        // time: O(N)
        // space: O(N + M), if the number of balls are large, we should use HashMap instead
        Map<Integer, Integer> colorNum = new HashMap<>();
        // use array to save the ball color mapping
        int[] ballColor = new int[limit + 1];
        int n = queries.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballColor[ball] != 0) {
                // the ball has been printed before
                int prevColor = ballColor[ball];
                int prevCount = colorNum.get(prevColor);
                // update the color map
                if (prevCount == 1) {
                    colorNum.remove(prevColor);
                } else {
                    colorNum.put(prevColor, prevCount - 1);
                }
            }
            colorNum.put(color, colorNum.getOrDefault(color, 0) + 1);
            ballColor[ball] = color;

            res[i] = colorNum.size();
        }

        return res;
    }
}
