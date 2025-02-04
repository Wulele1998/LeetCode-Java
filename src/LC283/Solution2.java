package LC283;

public class Solution2 {
    public void moveZeroes(int[] nums) {
        // N: the length of `num`
        // time: O(N)
        // space: O(1)
        int n = nums.length;

        int noneZeroIndex = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[noneZeroIndex++] = nums[i];
            }
        }

        for (int i = noneZeroIndex; i < n; i++) {
            nums[i] = 0;
        }
    }
}
