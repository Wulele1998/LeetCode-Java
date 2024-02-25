package LC183;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(N)
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (n == 0) {
            res.add(Arrays.asList(lower, upper));
            return res;
        }

        int start = lower;

        for (int i = 0; i < n; i++) {
            if (nums[i] > start) {
               res.add(Arrays.asList(start, nums[i] - 1));
            }
            start = nums[i] + 1;
        }
        
        if (nums[n - 1] < upper) {
            res.add(Arrays.asList(nums[n - 1] + 1, upper));
        }

        return res;
    }
}
