package LC2070;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // M: the length of `items`
        // N: the length of `queries`
        // time: O((M + N) * logM)
        // space: O(N + log M)
        int[] res = new int[queries.length];
        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));

        int[] maxCache = new int[items.length];
        int maxBeauty = 0;
        for (int i = 0; i < items.length; i++) {
            maxBeauty = Math.max(maxBeauty, items[i][1]);
            maxCache[i] = maxBeauty;
        }


        for (int i = 0; i < queries.length; i++) {
            // binary search find the index of price
            int left = 0;
            int right = items.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (items[mid][0] <= queries[i]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            res[i] = left == 0 ? 0 : maxCache[left - 1];
        }

        return res;
    }
}
