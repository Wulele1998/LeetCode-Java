package LC2064;

public class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        // N: the length of `quantities`
        // M: the max value in `quantities`
        // time: O(N * logM)
        // space: O(1)
        int maxValue = 0;
        for (int quantity : quantities) {
            maxValue = Math.max(maxValue, quantity);
        }

        if (n == quantities.length)
            return maxValue;

        // binary search
        int low = 1;
        int high = maxValue;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(n, quantities, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean isValid(int n, int[] quantities, int m) {
        int need = 0;
        for (int quantity : quantities) {
            need += quantity % m == 0 ? (quantity / m) : (quantity / m + 1);
        }

        return need <= n;
    }
}
