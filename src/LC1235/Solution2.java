package LC1235;

import java.util.Arrays;
import java.util.Comparator;

public class Solution2 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // bottom up DP
        int n = profit.length;
        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < n; i++) {
            startTime[i] = jobs[i][0];
        }

        return findMaxProfitBottomUp(jobs, startTime, n);
    }

    private int findMaxProfitBottomUp(int[][] jobs, int[] startTime, int n) {
        int[] memo = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            // start from right, as base case
            if (i == n - 1) {
                // base case
                memo[n - 1] = jobs[n - 1][2];
            } else {
                int currentProfit = 0;
                int nextJobIndex = findNextJobIndex(startTime, jobs[i][1]);
                if (nextJobIndex < n) {
                    currentProfit += jobs[i][2] + memo[nextJobIndex];
                } else {
                    currentProfit = jobs[i][2];
                }
                memo[i] = Math.max(currentProfit, memo[i + 1]);
            }
        }

        return memo[0];
    }

    private int findNextJobIndex(int[] startTime, int lastJobEndTime) {
        int left = 0;
        int right = startTime.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (startTime[mid] >= lastJobEndTime) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
