package LC3160;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 3160. Find the Number of Distinct Colors Among the Balls
 */
public class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        // N: the number of `queries`
        // M: the number of balls
        // time: O(N)
        // space: O(N)
        Map<Integer, Integer> ballColor = new HashMap<>();
        Map<Integer, Integer> colorNum = new HashMap<>();
        int n = queries.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballColor.containsKey(ball)) {
                // the ball has been printed before
                int prevColor = ballColor.get(ball);
                int prevCount = colorNum.get(prevColor);
                // update the color map
                if (prevCount == 1) {
                    colorNum.remove(prevColor);
                } else {
                    colorNum.put(prevColor, prevCount - 1);
                }
            }
            colorNum.put(color, colorNum.getOrDefault(color, 0) + 1);
            ballColor.put(ball, color);

            res[i] = colorNum.size();
        }

        return res;
    }
}
