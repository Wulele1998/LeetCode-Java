package LC2054;

import java.util.ArrayList;
import java.util.List;

/**
 * Dec 24, 2025
 * LC 2054. Two Best Non-Overlapping Events
 */
public class Solution2 {
    public int maxTwoEvents(int[][] events) {
        List<int[]> timeSlots = new ArrayList<>();
        for (int[] event : events) {
            timeSlots.add(new int[] {0, event[0], event[2]});
            timeSlots.add(new int[] {1, event[1], event[2]});
        }

        timeSlots.sort((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0]; // start time slot should sort ahead the end time slot
            }
            return o1[1] - o2[1];
        });

        int maxVal = 0;
        int maxValEnded = 0;
        for (int[] timeSlot : timeSlots) {
            if (timeSlot[0] == 0) {
                // start time slot, current event starts
                maxVal = Math.max(maxVal, timeSlot[2] + maxValEnded);
            } else if (timeSlot[0] == 1) {
                // end time slot, current event ended
                // update the maxValEnded
                maxValEnded = Math.max(maxValEnded, timeSlot[2]);
            }
        }

        return maxVal;
    }
}
