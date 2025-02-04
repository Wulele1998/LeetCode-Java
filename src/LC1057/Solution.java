package LC1057;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class WorkerBikePair implements Comparable<WorkerBikePair> {
    int workerIndex;
    int bikeIndex;
    int distance;

    public WorkerBikePair(int workerIndex, int bikeIndex, int distance) {
        this.workerIndex = workerIndex;
        this.bikeIndex = bikeIndex;
        this.distance = distance;
    }

    public int compareTo(WorkerBikePair pair) {
        if (this.distance != pair.distance) {
            return this.distance - pair.distance;
        } else if (this.workerIndex != pair.workerIndex) {
            return this.workerIndex - pair.workerIndex;
        } else {
            return this.bikeIndex - pair.bikeIndex;
        }
    }
}

public class Solution {
    private int getDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        List<WorkerBikePair> allPairs = new ArrayList<>();
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                allPairs.add(new WorkerBikePair(i, j, getDistance(workers[i], bikes[j])));
            }
        }

        Collections.sort(allPairs);
        
        boolean[] bikesUsed = new boolean[bikes.length];
        boolean[] workersUsed = new boolean[workers.length];
        int[] res = new int[workers.length];
        int count = 0;

        for (WorkerBikePair pair : allPairs) {
            if (!workersUsed[pair.workerIndex] && !bikesUsed[pair.bikeIndex]) {
                count++;
                bikesUsed[pair.bikeIndex] = true;
                workersUsed[pair.workerIndex] = true;
                res[pair.workerIndex] = pair.bikeIndex;
            }
            if (count == workers.length)
                break;
        }
        
        return res;
    }
}
