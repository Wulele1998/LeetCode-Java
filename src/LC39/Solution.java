package LC39;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        backtrackHelper(candidates, target, 0, 0, new ArrayList<>());

        return res;
    }

    /**
     * @param candidates candidates array
     * @param target target number
     * @param index current index of candidates array
     * @param sum current sum of the list
     * @param list the list that saves the combination
     */
    private void backtrackHelper(int[] candidates, int target, int index, int sum, List<Integer> list) {
        // base case 1: the condition to end the recursion
        if (sum == target) {
            // found qualified combination, add to the result list, make a deep copy
            res.add(new ArrayList<>(list));
            return;
        }
        // base case 2: sum is larger than target or index reaches the end of the candidates array
        if (sum > target || index == candidates.length)
            return;

        // case 1: use current candidate number in the combination
        list.add(candidates[index]);
        // since we can use it unlimited number of times, no updates needed for index
        backtrackHelper(candidates, target, index, sum + candidates[index], list);

        // backtrack  to its previous state
        list.removeLast();
        // case 2: don't use current candidate number in the combination
        backtrackHelper(candidates, target, index + 1, sum, list);
    }
}
