package LC3315;

import java.util.List;

/**
 * Jan 21, 2026
 * LC 3315. Construct the Minimum Bitwise Array II
 */
public class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] res = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            res[i] = findMinBitwise(nums.get(i));
        }

        return res;
    }  

    private int findMinBitwise(int num) {
        // x | (x + 1) = num
        // 10 | 11 = 11
        // 01 | 10 = 11
        // 100 | 101 = 101
        // 011 | 100 = 111
        if (num == 2) {
            return -1;
        }

        int x = 0;
        int digit = 1;
        while ((digit & num) != 0) {
            x += digit;
            num -= digit;
            digit <<= 1; // move the digit left
        }

        // digit in `num` is 0
        // move digit to right and set it to 0
        x -= digit / 2;
        x += num;

        return x;
    }
}
