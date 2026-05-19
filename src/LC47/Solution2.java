package LC47;

import java.util.*;

public class Solution2 {
    private Map<Integer, Integer> numsFreqMap;
    private List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        // initialization
        numsFreqMap = new HashMap<>();
        res = new ArrayList<>();

        for (int num : nums) {
            numsFreqMap.put(num, numsFreqMap.getOrDefault(num, 0) + 1);
        }

        backtrackHelper(nums, new ArrayList<>());

        return res;
    }

    private void backtrackHelper(int[] nums, List<Integer> curList) {
        // recursion base case
        if (curList.size() == nums.length) {
            // add the deep copy of current list as one permutation
            res.add(new ArrayList<>(curList));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : numsFreqMap.entrySet()) {
            // traverse the whole hash map to find available numbers to add into the current list
            int key = entry.getKey();
            int val = entry.getValue();
            if (val > 0) {
                curList.add(key);
                numsFreqMap.put(key, val - 1); // update the frequency of the num we used
                // move to next position of current list
                backtrackHelper(nums, curList);
                // backtrack, move up to previous state
                curList.removeLast();
                numsFreqMap.put(key, val);
            }
        }
    }
}
