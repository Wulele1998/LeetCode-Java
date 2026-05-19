package LC621;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution2 {
    public int leastInterval(char[] tasks, int n) {
        // N: the number of tasks
        // time: O(N), the size of PriorityQueue is constant
        int[] taskFreq = new int[26];
        for (char task : tasks) {
            taskFreq[task - 'A']++;
        }

        // {frequency, next task start time}
        Queue<int[]> freqMaxHeap = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        Queue<int[]> startTimeMinHeap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (int i = 0; i < 26; i++) {
            if (taskFreq[i] > 0) {
                freqMaxHeap.offer(new int[] {taskFreq[i], 0});
            }
        }

        int clock = 0;
        while (!freqMaxHeap.isEmpty() || !startTimeMinHeap.isEmpty()) {
            if (!freqMaxHeap.isEmpty()) {
                // get next task from freqMaxHeap
                int[] curTask = freqMaxHeap.poll();
                clock++;
                curTask[1] = clock + n;
                curTask[0]--;
                if (curTask[0] > 0) {
                    startTimeMinHeap.offer(curTask);
                }
            } else {
                // if freqMaxHeap is empty, move the earliest task from the cool down heap
                clock = startTimeMinHeap.peek()[1];
            }

            while (!startTimeMinHeap.isEmpty() && startTimeMinHeap.peek()[1] <= clock) {
                freqMaxHeap.offer(startTimeMinHeap.poll());
            }
        }

        return clock;
    }
}
