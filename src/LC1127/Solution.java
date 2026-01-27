package LC1127;

/**
 * LC 1227. Airplane Seat Assignment Probability
 */
public class Solution {
    public double nthPersonGetsNthSeat(int n) {
        // time: O(N)
        // space: O(1)
        // n = 1, f(1) = 1.0
        // n = 2, f(2) = 1/2 * 1 + 1/2 * 0;
        // n = 3, f(3) = 1/3 * 1 (set at 1) + 1/3 * f(2) (sit at 2) + 1/3 * 0 (sit at 3)
        // n = 4, f(4) = 1/4 * 1 (set at 1) + 1/4 * f(3) (sit at 2) + 1/4 * f(3) (sit at 3) + 1/4 * 0

        // edge case:
        if (n == 1) {
            return 1.0;
        }
        if (n == 2) {
            return 0.5;
        }
        double prevDp = 0.5;
        for (int i = 3; i <= n; i++) {
            prevDp = 1.0 / n * 1 + 1.0 / n * (n - 2) * prevDp;
        }

        return prevDp;
    }
}
