package LC2054;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Dec 24, 2025
 * LC 2054. Two Best Non-Overlapping Events
 */
public class Solution {
    public int maxTwoEvents(int[][] events) {
        // use min heap
        // 1. Sort the `events` according to the start time
        // 2. Using the priority queue to store all events,
        // find the max value among all qualified (already ended) events
        // 3. the max value will be the current events and the max value events have eneded


        // N: the number of `events`
        // time: O(N logN)
        // space: O(N)
        int maxVal = 0;
        // [start, end, value]
        // the min heap is sorted based on the event end time
        PriorityQueue<int[]> endedEvents = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        // sort all events based on start time
        // time: O(N logN), space: average O(logN), worst case is O(N)
        Arrays.sort(events, (o1, o2) -> o1[0] - o2[0]);

        int maxValEnded = 0;
        // time: O(N logN)
        for (int[] event : events) {
            while (!endedEvents.isEmpty() && endedEvents.peek()[1] < event[0]) {
                // the end time need to be earlier than the current event start time
                maxValEnded = Math.max(maxValEnded, endedEvents.poll()[2]);
            }

            endedEvents.add(event); // add event to priority queue, O(logN)
            maxVal = Math.max(maxVal, maxValEnded + event[2]);
        }

        return maxVal;

    }
}
