package LC1066;

/**
 * LC 1066. Campus Bikes II
 */
public class Solution {
    int res = Integer.MAX_VALUE;
    boolean[] visitedBikes;

    public int assignBikes(int[][] workers, int[][] bikes) {
        // greedy backtracking
        // time: O(M!)
        // space: O(N) + O(M) recursion stack and the visited boolean array
        visitedBikes = new boolean[bikes.length];
        miniDistanceSum(workers, bikes, 0, 0);

        return res;
    }   

    private void miniDistanceSum(int[][] workers, int[][] bikes, int workerIndex, int distance) {
        if (workerIndex == workers.length) {
            // all workers get bike assigned, update the result
            res = Math.min(res, distance);
            return;
        }

        if (distance > res) {
            // if the current distance is larger than the result, no need to proceed anymore
            return;
        }

        for (int bikeIndex = 0; bikeIndex < bikes.length; bikeIndex++) {
            if (!visitedBikes[bikeIndex]) {
                visitedBikes[bikeIndex] = true;
                int extraDistance = getDistance(workers[workerIndex], bikes[bikeIndex]);
                miniDistanceSum(workers, bikes, workerIndex + 1, distance + extraDistance);

                // backtrack
                visitedBikes[bikeIndex] = false;
            }
        }
    }

    private int getDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}