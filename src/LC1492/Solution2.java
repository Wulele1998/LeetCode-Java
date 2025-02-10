package LC1492;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LC 1492. The kth Factor of n
 */
public class Solution2 {
    public int kthFactor(int n, int k) {
        // N: the number of `n`
        // time: O(N)
        // space: O(1)

        for (int i = 1; i <= n && k > 0; i++) {
            if (n % i == 0) {
                k--;
                if (k == 0) {
                    return i;
                }
            }
        }

        return -1;
    }
}
