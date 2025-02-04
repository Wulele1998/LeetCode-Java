package LC2017;

/**
 * LC 2017. Grid Game
 */
public class Solution {
    public long gridGame(int[][] grid) {
        // prefix sum and suffix sum
        // N: the number of columns in `grid`
        // time: O(N)
        // space: O(1)
        int n = grid[0].length;
        long prefixSum = 0L;
        long suffixSum = 0L;
        long res = Long.MAX_VALUE;

        for (int num : grid[0]) {
            prefixSum += num;
        }

        for (int i = 0; i < n; i++) {
            prefixSum -= grid[0][i];
            res = Math.min(res, Math.max(prefixSum, suffixSum));
            suffixSum += grid[1][i];
        }

        return res;
    }
}
