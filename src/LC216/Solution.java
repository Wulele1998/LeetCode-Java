package LC216;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // time: O(K * C(9, K))
    // C(9, K) means the number of ways to choose K elements from integer in range [1, 9]
    // C(N, K) = N! / ((N - K)! * K!)
    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();

        backtrackHelper(k, n, 1, 0, new ArrayList<>());

        return res;
    }

    /**
     * backtrack helper recursion function that founds qualified combinations
     * @param k the length of qualified combination
     * @param target the sum of qualified combination
     * @param num the number of current recursion, we can select the number from range interval [num, 9]
     * @param sum the sum of current list combination
     * @param curList current list that stores current combination
     */
    private void backtrackHelper(int k, int target, int num, int sum, List<Integer> curList) {
        // base case 1: sum == target && curList.size() == k
        if (sum == target && curList.size() == k) {
            res.add(new ArrayList<>(curList)); // O(K) for deep copy the current list whose length is K
            return;
        }
        // base case 2
        if (sum >= target || curList.size() >= k) {
            return;
        }

        // we can choose next number from [num, 9]
        for (int cur = num; cur <= 9; cur++) {
            curList.add(cur);
            backtrackHelper(k, target, cur + 1, sum + cur, curList);
            // backtrack to previous state for next for loop
            curList.removeLast();
        }
    }
}
