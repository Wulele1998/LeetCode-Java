package LC1464;

public class Solution2 {
    public int maxProduct(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(1)
        int maxNum = Math.max(nums[0], nums[1]);
        int maxNum2 = Math.min(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > maxNum) {
                maxNum2 = maxNum;
                maxNum = nums[i];
            } else if (nums[i] > maxNum2) {
                maxNum2 = nums[i];
            }
        }

        return (maxNum - 1) * (maxNum2 - 1);
    }
}
