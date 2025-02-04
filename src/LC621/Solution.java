package LC621;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * LC 621. Task Scheduler
 */
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        // N: the number of tasks
        // time: O(N)
        // space: O(1)
        int[] map = new int[26];
        for (char task : tasks) {
            map[task - 'A']++;
        }   

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0)
                maxHeap.add(map[i]);
        }

        int time = 0;
        while (!maxHeap.isEmpty()) {
            int cycle = n + 1;
            List<Integer> store = new ArrayList<>();
            int taskCount = 0;
            while (cycle-- > 0 && !maxHeap.isEmpty()) {
                int cur = maxHeap.poll();
                if (cur > 1) {
                    store.add(cur - 1);
                }
                taskCount++;
            }

            store.forEach(maxHeap::add);
            time += (maxHeap.isEmpty() ? taskCount : n + 1);
        }

        return time;
    }
}
