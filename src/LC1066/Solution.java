package LC1066;

public class Solution {
    int res = Integer.MAX_VALUE;
    boolean[] visitedBike;

    public int assignBikes(int[][] workers, int[][] bikes) {
        // greedy backtracking
        // time: O(M!)
        // space: O(N) + O(M) recursion stack and the visited boolean array
        visitedBike = new boolean[bikes.length];
        miniDistanceSum(workers, bikes, 0, 0);
        return res;
    }   

    private void miniDistanceSum(int[][] works, int[][] bikes, int index, int curDistance) {
        if (index == works.length) {
            res = Math.min(res, curDistance);
            return; // one branch finished
        }
        
        if (curDistance >= res) {
            return; // ended in advance
        }
        
        for (int i = 0; i < bikes.length; i++) {
            if (!visitedBike[i]) {
                visitedBike[i] = true;
                miniDistanceSum(works, bikes, index + 1, curDistance + getDistance(works[index], bikes[i]));
                // backtrack
                visitedBike[i] = false;
            }
        }
    }

    private int getDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}