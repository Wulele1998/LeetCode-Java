package LC252;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        // N: the length of `intervals`
        // time: O(N log N)
        // space: O(log N)
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int n = intervals.length;

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < intervals[i - 1][1])
                return false;
        }

        return true;
    }
}
