package LC2402;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LC 2402. Meeting Rooms III
 */
public class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // M: the length of `meetings`
        // N: the number of meeting rooms `n`
        // time: O(M log M + M log N + N log N)
        // space: O(log M + N)
        int[] meetingCount = new int[n];
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));
        // [end time, number]
        PriorityQueue<int[]> usingRoom = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        PriorityQueue<Integer> availableRoom = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            availableRoom.add(i);
        }

        for (int[] meeting : meetings) {
            // KEY: need to update the available meeting rooms
            while (!usingRoom.isEmpty() && usingRoom.peek()[0] <= meeting[0]) {
                int roomNum = usingRoom.poll()[1];
                availableRoom.add(roomNum);
            }
            if (!availableRoom.isEmpty()) {
                int roomNum = availableRoom.poll();
                usingRoom.add(new int[] {meeting[1], roomNum});
                meetingCount[roomNum]++;
            } else {
                // no free room
                int duration = meeting[1] - meeting[0];
                int[] roomInfo = usingRoom.poll();
                int startTime = roomInfo[0];
                int roomNum = roomInfo[1];
                usingRoom.add(new int[] {startTime + duration, roomNum});
                meetingCount[roomNum]++;
            }
        }

        int index = 0;
        for (int i = 1; i < n; i++) {
            if (meetingCount[i] > meetingCount[index]) {
                index = i;
            }
        }

        return index;
    }
}
