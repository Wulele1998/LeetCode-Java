package LC1437;

public class Solution2 {
    public boolean kLengthApart(int[] nums, int k) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(1)
        int prev = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (prev != -1 && i - prev - 1 < k) {
                   return false;
                }
                prev = i;
            }
        }

        return true;
    }
}
