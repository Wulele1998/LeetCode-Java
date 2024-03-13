package LC2485;

/**
 * LC 2485. Find the Pivot Integer
 */
public class Solution {
    public int pivotInteger(int n) {
        // time: O(N)
        // space: O(1)
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        int prefixSum = 0;
        for (int i = 1; i <= n; i++) {
            if (sum - i == 2 * prefixSum) {
                return i;
            }
            prefixSum += i;
        }

        return -1;
    }
}
