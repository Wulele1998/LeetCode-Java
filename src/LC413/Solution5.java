package LC413;

public class Solution5 {
    public int numberOfArithmeticSlices(int[] nums) {
        // Dynamic Programming optimized space
        // N: the length of `nums`
        // time: O(N)
        // space: O(1)
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        int pre = 0;
        int sum = 0;

        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                pre++;
            } else {
                pre = 0;
            }

            sum += pre;
        }

        return sum;
    }
}
