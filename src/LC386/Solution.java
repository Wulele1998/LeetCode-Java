package LC386;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 386. Lexicographical Numbers
 */

public class Solution {
    List<Integer> res;
    // use DFS
    // time: O(N)
    // space: O(log N)
    public List<Integer> lexicalOrder(int n) {
        res = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            DFS(i, n);
        }

        return res;
    }

    private void DFS(int current, int end) {
        if (current > end) {
            return;
        }
        res.add(current);
        for (int i = 0; i <= 9; i++) {
            int num = current * 10 + i;
            if (num <= end) {
                DFS(num, end);
            } else {
                break;
            }
        }
    }
}
