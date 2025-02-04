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

    private boolean isValidSimulate(int n, int[] quantities, int m) {
        int productIndex = 0;
        int remaining = quantities[productIndex];

        // go through each store
        for (int i = 0; i < n; i++) {
            if (remaining > m) {
                remaining -= m;
            } else {
                productIndex++;
                if (productIndex == quantities.length) {
                    return true;
                }
                remaining = quantities[productIndex];
            }
        }

        return false;
    }
}
