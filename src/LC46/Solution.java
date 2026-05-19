package LC46;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // N: the number in `nums`
    // time: O(N!)
    private List<List<Integer>> res;
    private boolean[] used; // use to track whether the numbers has been used at current list permutation
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        used = new boolean[nums.length];

        backtrackHelper(nums, new ArrayList<>());

        return res;
    }

    /**
     * backtrack recursion helper function
     * @param nums numbers array
     * @param curList current list stores current permutation
     */
    private void backtrackHelper(int[] nums, List<Integer> curList) {
        // base case
        if (curList.size() == nums.length) {
            // deep copy current list and add into result
            res.add(new ArrayList<>(curList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                curList.add(nums[i]);
                used[i] = true;
                backtrackHelper(nums, curList);
                // backtrack to previous state and move to next number
                curList.removeLast(); // JDK 21
                used[i] = false;
            }
        }
    }
}
