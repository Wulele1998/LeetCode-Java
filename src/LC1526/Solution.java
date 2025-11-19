package LC1526;

/**
 * Oct 30, 2025
 * LC 1526. Minimum Number of Increments on Subarrays to Form a Target Array
 */
public class Solution {
    public int minNumberOperations(int[] target) {
        // N: the length of `target`
        // time: O(N)
        // space: O(1)
        // the number of increment is decided by layer
        // the number of layer is decided by the number of ascending
        int res = target[0];
        for (int i = 1; i < target.length; i++) {
            if (target[i] > target[i - 1]) {
                res += target[i] - target[i - 1];
            }
        }

        return res;
    }
}
