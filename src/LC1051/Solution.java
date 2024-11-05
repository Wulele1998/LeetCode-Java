package LC1051;

import java.util.Arrays;

/**
 * LC 1051. Height Checker
 */
public class Solution {
    public int heightChecker(int[] heights) {
        // N: the length of `heights`
        // time: O(N * logN)
        // space: O(N + log N)
        int[] sorted = heights.clone();
        Arrays.sort(sorted);
        int count = 0;

        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sorted[i]) {
                count++;
            }
        }

        return count;   
    }
}
