package LC1235;

import java.util.Arrays;
import java.util.Comparator;

/**
 * LC 1235. Maximum Profit in Job Scheduling
 */
public class Solution {
    int[] memo = new int[50000];
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // N: the number of jobs
        // time: O(N * logN)
        // space: O(N)
        int n = profit.length;
        int[][] jobs = new int[n][3];
        Arrays.fill(memo, -1);

        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0])); // sort base don the start time
        // rewrite the start time array
        for (int i = 0; i < n; i++) {
            startTime[i] = jobs[i][0];
        }

        // top-down DP
        return findMaxProfit(jobs, startTime, n, 0);
    }

    private int findMaxProfit(int[][] jobs, int[] startTime, int n, int curIndex) {
        if (curIndex == n) {
            return 0;
        }
        if (memo[curIndex] != -1) {
            // use the memo value, avoid duplicated calculation
            return memo[curIndex];
        }

        int nextJobIndex = findNextJob(startTime, jobs[curIndex][1], curIndex);
        int profitSkipCurrent = findMaxProfit(jobs, startTime, n, curIndex + 1);
        int profitSelectCurrent = jobs[curIndex][2] + findMaxProfit(jobs, startTime, n, nextJobIndex);
        memo[curIndex] = Math.max(profitSelectCurrent, profitSkipCurrent);
        return memo[curIndex];
    }

    private int findNextJob(int[] startTime, int lastJobEndTime, int curIndex) {
        int left = curIndex + 1;
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
