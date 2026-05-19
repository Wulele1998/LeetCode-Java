package LC40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // time: O(2 ^ N)
        // space: O(N)
        res = new ArrayList<>();
        Arrays.sort(candidates); // sort to make all the same numbers next to each other, to avoid the duplication in recursion

        backtrackHelper(candidates, target, 0, 0, new ArrayList<>());

        return res;
    }

    /**
     * backtrack recursion helper function
     * @param candidates candidates array
     * @param target target sum of the combination
     * @param index the index of the candidates array of current recursion
     * @param sum the sum of current combination
     * @param curList the combination of current recursion
     */
    private void backtrackHelper(int[] candidates, int target, int index, int sum, List<Integer> curList) {
        // base case 1: sum == target, qualified combination => deep copy the current list and add into the result
        if (sum == target) {
            res.add(new ArrayList<>(curList));
            return;
        }
        // base case 2: sum > target or index reach the end of the candidates array, end the recursion
        if (sum > target || index == candidates.length) {
            return;
        }

        // chose a number from candidates[index:] to add into combination
        for (int i = index; i < candidates.length; i++) {
            if (i != index && candidates[i] == candidates[i - 1]) {
                // skip the duplication numbers
                continue;
            }
            curList.add(candidates[i]); // add selected number into combination
            // next recursion, we will choose number from candidates[index + 1:]
            backtrackHelper(candidates, target, i + 1, sum + candidates[i], curList);
            // backtrack to previous state for next loop
            curList.removeLast();
        }
    }
}
