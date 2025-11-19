package LC1578;


/**
 * Nov 3, 2025
 * LC 1578. Minimum Time to Make Rope Colorful
 */
public class Solution {
    public int minCost(String colors, int[] neededTime) {
        // N: the length of `colors`
        // time: O(N)
        // space: O(1)
        int res = 0;
        int n = colors.length();
        int maxTimeInSameColor = neededTime[0];
        int sumTimeInSameColor = neededTime[0];
        for (int i = 1; i < n; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                maxTimeInSameColor = Math.max(maxTimeInSameColor, neededTime[i]);
                sumTimeInSameColor += neededTime[i];
            } else {
                // the color changed
                // if there is only 1 balloon in that color, it should be 0
                res += sumTimeInSameColor - maxTimeInSameColor;
                // start the next color
                maxTimeInSameColor = neededTime[i];
                sumTimeInSameColor = neededTime[i];
            }
        }

        // the last color
        res += sumTimeInSameColor - maxTimeInSameColor;

        return res;
    }
}
