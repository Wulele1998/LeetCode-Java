package LC1014;

public class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        // Dynamic Programming
        // N: the length of `values`
        // time: O(N)
        // space: O(N)
        int maxRes = values[0];
        int curMax = values[0];
        int n = values.length;

        for (int i = 1; i < n; i++) {
            maxRes = Math.max(maxRes, curMax + values[i] - i);
            curMax = Math.max(curMax, values[i] + i);
        }

        return maxRes;
    }
}
