package LC90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    private List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        backtrackHelper(nums, 0, new ArrayList<>());
        return res;
    }

    private void backtrackHelper(int[] nums, int index, List<Integer> current) {
        if (index == nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        backtrackHelper(nums, index + 1, current);
        current.removeLast();

        while (index < nums.length - 1 && nums[index] == nums[index + 1]) {
            index++;
        }

        backtrackHelper(nums, index + 1, current);
    }
}
