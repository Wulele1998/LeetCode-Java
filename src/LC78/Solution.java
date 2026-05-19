package LC78;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        backtrackHelper(nums, 0, new ArrayList<>());
        return res;
    }

    /**
     * @param nums nums array
     * @param index current index of nums
     * @param list the ArrayList that stores current list
     */
    private void backtrackHelper(int[] nums, int index, List<Integer> list) {
        // base case => overall reach the end of the nums
        // we go through every node in the tree
        res.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            // case 1: we add nums[index] into current list
            list.add(nums[i]);
            backtrackHelper(nums, i + 1, list);
            // case 2: we don't add nums[index] into current list
            // backtrack to previous state
            list.removeLast();
        }
    }
}
