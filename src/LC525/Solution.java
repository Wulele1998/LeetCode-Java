package LC525;

import java.util.Arrays;

/**
 * LC 525. Contiguous Array
 */
public class Solution {
    public int findMaxLength(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(N)
        int n = nums.length;
        int[] counts = new int[n * 2 + 1];
        Arrays.fill(counts, -2);
        counts[n] = -1;
        int count = 0;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            count += (nums[i] == 0 ? -1 : 1);
            if (counts[count + n] >= -1) {
                maxLength = Math.max(maxLength, i - counts[count + n]);
            } else {
                counts[count + n] = i;
            }
        }

        return maxLength;
    }
}
