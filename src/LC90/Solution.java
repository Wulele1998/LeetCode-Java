package LC90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        // sort the `nums` array to make same numbers next to each other
        Arrays.sort(nums);
        backtrackHelper(nums,0, new ArrayList<>());

        return res;
    }

    private void backtrackHelper(int[] nums, int index, List<Integer> current) {
        res.add(new ArrayList<>(current)); // make a deep copy of current list

        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            current.add(nums[i]);
            backtrackHelper(nums, i + 1, current);
            current.removeLast();
        }
    }
}
