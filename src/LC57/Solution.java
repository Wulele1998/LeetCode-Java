package LC57;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LC 57. Insert Interval
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // N: the length of `intervals`
        // time: O(N + log N)
        // space: O(N)
        int n = intervals.length;
        int low = 0, high = n - 1;
        int target = newInterval[0];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (intervals[mid][0] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        List<int[]> temp = new ArrayList<>();
        for (int i = 0; i < low; i++) {
            temp.add(intervals[i]);
        }
        temp.add(newInterval);
        for (int i = low; i < n; i++) {
            temp.add(intervals[i]);
        }

        LinkedList<int[]> res = new LinkedList<>();
        for (int[] arr : temp) {
            if (res.isEmpty() || res.getLast()[1] < arr[0]) {
                res.add(arr);
            } else {
                res.getLast()[1] = Math.max(res.getLast()[1], arr[1]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
