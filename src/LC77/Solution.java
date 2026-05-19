package LC77;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        backtrackHelper(n, k, 1, new ArrayList<>());

        return res;
    }

    private void backtrackHelper(int n, int k, int num, List<Integer> current) {
        if (current.size() == k) {
            res.add(new ArrayList<>(current));
            return;
        }

        for (int i = num; i <= n; i++) {
            current.add(i);
            backtrackHelper(n, k, i + 1, current);
            current.removeLast();
        }
    }
}
