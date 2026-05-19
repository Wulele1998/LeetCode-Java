package LC47;

import java.util.*;

public class Solution {
    private List<List<Integer>> res;
    private Set<String> resSet;
    private boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        resSet = new HashSet<>();
        used = new boolean[nums.length];

        backtrackHelper(nums, new ArrayList<>());

        return res;
    }

    private void backtrackHelper(int[] nums, List<Integer> curList) {
        if (curList.size() == nums.length) {
            if (!resSet.contains(curList.toString())) {
                resSet.add(curList.toString());
                res.add(new ArrayList<>(curList));
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                curList.add(nums[i]);
                backtrackHelper(nums, curList);
                used[i] = false;
                curList.removeLast();
            }
        }
    }
}
