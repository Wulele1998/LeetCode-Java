package LC621;

import java.util.*;

/**
 * LC 621. Task Scheduler
 */
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskFreq = new int[26];
        for (char task : tasks) {
            taskFreq[task - 'A']++;
        }

        Queue<Integer> freqMaxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < 26; i++) {
            if (taskFreq[i] > 0) {
                freqMaxHeap.offer(taskFreq[i]);
            }
        }

        int clock = 0;
        while (!freqMaxHeap.isEmpty()) {
            int curTaskFreq = freqMaxHeap.poll();
            clock++;
            curTaskFreq--;
            if (curTaskFreq > 0) {
                // n intervals cool down
                // store all tasks that can be run during the cool down time
                List<Integer> taskList = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if (!freqMaxHeap.isEmpty()) {
                        int nextTaskFreq = freqMaxHeap.poll();
                        nextTaskFreq--;
                        if (nextTaskFreq > 0)
                            taskList.add(nextTaskFreq);
                    }
                    clock++;
                }
                freqMaxHeap.offer(curTaskFreq);
                freqMaxHeap.addAll(taskList);
            }
        }

        return clock;
    }
}
