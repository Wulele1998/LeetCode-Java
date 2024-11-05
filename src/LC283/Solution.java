package LC283;

public class Solution {
    public void moveZeroes(int[] nums) {
        // N: the length of `num`
        // time: O(N)
        // space: O(1)
        int n = nums.length;
        int zeroIndex = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                zeroIndex++;
            }

            if (nums[i] != 0 && zeroIndex < i) {
                // find the non-zero number to move
                nums[zeroIndex] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
