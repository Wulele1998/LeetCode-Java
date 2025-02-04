package LC3151;

/**
 * LC 3151. Special Array I
 */
public class Solution {
    public boolean isArraySpecial(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(1)
        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] + nums[i + 1]) % 2 == 0) {
                return false;
            }
        }

        return true;
    }
}
