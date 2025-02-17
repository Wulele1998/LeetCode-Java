package LC1014;

public class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        // Dynamic Programming
        // N: the length of `values`
        // time: O(N)
        // space: O(1)
        int n = values.length;
        int maxScore = 0;
        int curMax = values[0];

        for (int i = 1; i < n; i++) {
            maxScore = Math.max(maxScore, curMax + values[i] - i);
            curMax = Math.max(curMax, values[i] + i);
        }

        return maxScore;
    }
}
