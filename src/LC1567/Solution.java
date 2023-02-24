package LC1567;

public class Solution {
    public int getMaxLen(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(1)
        // pos: the longest consecutive numbers forming a positive product
        // neg: the longest consecutive numbers forming a negative product
        int maxLen = 0;
        int pos = 0;
        int neg = 0;

        for (int num : nums) {
            if (num == 0) {
                pos = 0;
                neg = 0;
            } else if (num > 0) {
                pos++;
                neg = neg == 0 ? 0 : neg + 1;
            } else {
                int temp = pos;
                // neg * neg = pos
                // pos * neg = neg
                pos = neg == 0 ? 0 : neg + 1;
                neg = temp + 1;
            }

            maxLen = Math.max(maxLen, pos);
        }

        return maxLen;
    }
}
