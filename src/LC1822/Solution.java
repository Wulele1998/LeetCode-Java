package LC1822;

public class Solution {
    public int arraySign(int[] nums) {
        // N: the number of `nums`
        // time: O(N)
        // space: O(1)
        int neg = 0;

        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                neg++;
            }
        }

        return (neg & 1) == 0 ? 1 : -1;
    }
}
