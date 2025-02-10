package LC1492;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LC 1492. The kth Factor of n
 */
public class Solution {
    public int kthFactor(int n, int k) {
        // N: the number of `n`
        // time: O(√N)
        // space: O(N)
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                list.add(i);
                if (i * i != n) {
                    stack.push(i);
                }
            }
        }

        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }

        return list.size() >= k ? list.get(k - 1) : -1;
    }
}
