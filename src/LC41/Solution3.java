package LC41;

/**
 * LC 41. First Missing Positive
 */
public class Solution3 {
    public int firstMissingPositive(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(1)
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int correctIndex = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
