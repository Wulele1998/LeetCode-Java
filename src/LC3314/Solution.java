package LC3314;

import java.util.List;

/**
 * Jan 20, 2026
 * LC 3314. Construct the Minimum Bitwise Array I
 */
public class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        // N: the length of `nums`
        // M: the max value in `nums`
        // time: O(N * logM)
        int n = nums.size();
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            // x | (x + 1) = num => set the x's rightmost (least significant) 0 to 1
            // 100 | 101 = 101
            // 011 | 100 = 111
            // need the minimum x
            // num: 1011
            // x: 1001 | 1010 = 1011
            // x: 1010 | 1011 = 1011
            // x: 0011 | 0100 = 0100
            int ans = -1;
            int bit = 1;
            while ((num & bit) != 0) {
                // in current bit, the value is 1
                ans = num - bit;
                bit <<= 1; // move left, increase to next bit
            }

            res[i] = ans;
        }

        return res;
    }
}
