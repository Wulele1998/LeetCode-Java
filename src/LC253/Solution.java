package LC253;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // N: the length of `intervals`
        // time: O(N log N)_
        // space: O(N)
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o));

        minHeap.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.add(intervals[i][1]);
        }

        return minHeap.size();
    }
}
