package LC3048;

import java.util.Arrays;

/**
 * 3048. Earliest Second to Mark Indices I
 */
public class Solution {
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        // N: the length of `changeIndices`
        // M: the length of `nums`
        // time: O(log N * (N + M))
        // space: O(N + M)
        // 1-indexed => 0-indexed
        int[] changeIndicesAdj = Arrays.stream(changeIndices).map(index -> index - 1).toArray();
        // binary search to save time
        int low = 0;
        int high = changeIndices.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isPossible(nums, changeIndicesAdj, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return isPossible(nums, changeIndicesAdj, low) ? low + 1 : -1;
    }

    // check if it is possible to mark all indices in `s` seconds
    private boolean isPossible(int[] nums, int[] changeIndices, int s) {
        int n = nums.length;
        int[] last = new int[n];
        Arrays.fill(last, -1);

        // last point to mark the index
        for (int i = 0; i <= s; i++) {
            last[changeIndices[i]] = i;
        }

        int marked = 0;
        int operations = 0;
        for (int i = 0; i <= s; i++) {
            if (i == last[changeIndices[i]]) {
                // do the mark operation
                if (nums[changeIndices[i]] > operations) {
                    // cannot complete the decrement
                    return false;
                }
                operations -= nums[changeIndices[i]];
                marked++;
            } else {
                operations++;
            }
        }

        return marked == n;
    }
}
