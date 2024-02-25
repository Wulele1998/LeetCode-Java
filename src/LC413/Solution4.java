package LC413;

public class Solution4 {
    public int numberOfArithmeticSlices(int[] nums) {
        // Dynamic Programming
        // N: the length of `nums`
        // time: O(N)
        // space: O(N)
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        int[] dp = new int[n];
        int sum = 0;
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 0;
            }
            sum += dp[i];
        }

        return sum;
    }
}
