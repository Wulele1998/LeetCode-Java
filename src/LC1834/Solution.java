package LC1834;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] res = new int[n];
        int[][] sortedTasks = new int[n][3];

        for (int i = 0; i < n; i++) {
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = tasks[i][1];
            sortedTasks[i][2] = i;
        }

        Arrays.sort(sortedTasks, new Comparator<int[]>() {
            @Override
            public int compare(int[] task1, int[] task2) {
                return task1[0] - task2[0];
            }
        });

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] task1, int[] task2) {
                if (task1[1] == task2[1]) { // same processing time
                    return task1[2] - task2[2];
                } else { // different processing time, shortest has higher priority
                    return task1[1] - task2[1];
                }
            }
        });

        int curIndex = 0;
        int curTime = 0;
        int resIndex = 0;
        while (curIndex < n || !minHeap.isEmpty()) {
            if (minHeap.isEmpty() && curTime < sortedTasks[curIndex][0]) {
                curTime = sortedTasks[curIndex][0];
            }
            while (curIndex < n && curTime >= sortedTasks[curIndex][0]) {
                minHeap.add(sortedTasks[curIndex]);
                curIndex++;
            }
            int[] doneTask = minHeap.poll();
            res[resIndex++] = doneTask[2];
        }

        return res;
    }
}
