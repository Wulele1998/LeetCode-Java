package LC3075;

import java.util.Arrays;

/**
 * Dec 25, 2025
 * LC 3075. Maximize Happiness of Selected Children
 */
public class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        // Greedy
        // N: the length of `happiness`
        // time: O(N log N + K)
        // space: O(log N)
        Arrays.sort(happiness);
        long res = 0L;
        int index = happiness.length - 1;
        int count = 0;
        while (k > 0) {
            res += Math.max(happiness[index] - count, 0);
            index--;
            count++;
            k--;
        }

        return res;
    }
}
