package LC163;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> res = new ArrayList<>();
        // edge case: the nums is empty
        if (nums.length == 0) {
            res.add(List.of(lower, upper));
            return res;
        }

        if (lower < nums[0]) {
            res.add(List.of(lower, nums[0] - 1));
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                res.add(List.of(nums[i - 1] + 1, nums[i] - 1));
            }
        }
        if (nums[nums.length - 1] < upper) {
            res.add(List.of(nums[nums.length - 1] + 1, upper));
        }

        return res;
    }
}
