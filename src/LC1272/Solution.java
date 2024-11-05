package LC1272;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        // N: the length of `intervals`
        // time: O(N)
        // space: O(N)
        List<List<Integer>> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] > toBeRemoved[1] || interval[1] < toBeRemoved[0]) {
                res.add(Arrays.asList(interval[0], interval[1]));
            } else {
                if (interval[0] < toBeRemoved[0])  {
                    res.add(Arrays.asList(interval[0], toBeRemoved[0]));
                }
                if (interval[1] > toBeRemoved[1]) {
                    res.add(Arrays.asList(toBeRemoved[1], interval[1]));
                }
            }
        }

        return res;
    }
}
