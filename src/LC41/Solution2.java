package LC41;

/**
 * LC 41. First Missing Positive
 */
public class Solution2 {
    public int firstMissingPositive(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(1)
        boolean flag = false;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                flag = true;
            }
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }
        if (!flag)
            return 1;

        for (int i = 0; i < n; i++) {
            int value = Math.abs(nums[i]);
            if (value == n) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[value] = -Math.abs(nums[value]);
            }
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        if (nums[0] > 0) {
            return n;
        }

        return n + 1;
    }
}
