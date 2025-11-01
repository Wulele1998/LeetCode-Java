package LC1066;


import java.util.Arrays;

/**
 * LC 1066. Campus Bikes II
 */
public class Solution2 {
    int[] memo = new int[1024];
    public int assignBikes(int[][] workers, int[][] bikes) {
        // using memo to avoid repeat calculating
        // top-down DP (memoization)
        Arrays.fill(memo, -1);
        return getMinimumDistanceSum(workers, bikes, 0,0);
    }

    private int getMinimumDistanceSum(int[][] workers, int[][] bikes, int workerIndex, int mask) {
        if (workerIndex == workers.length) {
            return 0;
        }
        if (memo[mask] != -1) {
            return memo[mask];
        }

        int minimumDistanceSum = Integer.MAX_VALUE;
        for (int bikeIndex = 0; bikeIndex < bikes.length; bikeIndex++) {
            // check if the current bike is available
            if ((mask & (1 << bikeIndex)) == 0) {
                int updatedMask = mask | (1 << bikeIndex);
                int updatedDistanceSum = getMinimumDistanceSum(workers, bikes, workerIndex + 1, updatedMask) + getDistance(workers[workerIndex], bikes[bikeIndex]);
                minimumDistanceSum = Math.min(minimumDistanceSum, updatedDistanceSum);
            }
        }
        memo[mask] = minimumDistanceSum;

        return minimumDistanceSum;
    }

    private int getDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}
