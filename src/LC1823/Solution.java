package LC1823;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 1823. Find the Winner of the Circular Game
 */
public class Solution {
    public int findTheWinner(int n, int k) {
        // using List to simulate
        // N: the number `n`
        // time: O(N ^ 2), the remove function in list needs O(N)
        // space: O(N)
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int startIndex = 0;
        while (list.size() > 1) {
            int removeIndex = (startIndex + k - 1) % list.size();
            list.remove(removeIndex);
            startIndex = removeIndex;
        }

        return list.get(0);
    }
}