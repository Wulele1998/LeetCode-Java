package LC396;

public class Solution {
    public int maxRotateFunction(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int fun = 0;
        for (int i = 0; i < n; i++) {
            fun += i * nums[i];
        }
        int res = fun;
        for (int i = n - 1; i >= 0; i--) {
            fun += (sum - nums[i]);
            fun -= nums[i] * (n - 1);
            res = Math.max(res, fun);
        }

        return res;
    }
}
