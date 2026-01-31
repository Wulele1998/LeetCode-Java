package LC875;

/**
 * LC 875. Koko Eating Bananas
 */
public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // binary search
        // N: the length of `piles`
        // M: the maximum number in `piles`
        // time: O(N * logM)
        int low = 1;
        int high = 1;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (spendTime(piles, mid) <= h) {
                high = mid - 1; // try to eat less
            } else {
                low = mid + 1; // eat more
            }
        }

        return low;
    }

    private long spendTime(int[] piles, int k) {
        long time = 0;
        for (int pile : piles) {
            time += (pile % k == 0 ? (pile / k) : (pile / k + 1));
        }

        return time;
    }
}
