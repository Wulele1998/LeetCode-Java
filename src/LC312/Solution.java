package LC312;

import java.util.Arrays;

public class Solution {
    // DP Top-down
    private int[][] memo;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] numsExt = new int[n + 2];
        numsExt[0] = 1;
        numsExt[n + 1] = 1;
        System.arraycopy(nums, 0, numsExt, 1, n);

        memo = new int[n + 2][n + 2];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // initialize the memo
        }

        return getMaxCoinsInRange(numsExt, 1, n);
    }

    private int getMaxCoinsInRange(int[] nums, int left, int right) {
        // [left, right]
        // range invalid
        if (left > right) {
            return 0;
        }
        // check the cache to avoid repeat
        if (memo[left][right] != -1)
            return memo[left][right];

        // calculate the max coins can get between interval [left, right]
        int res = 0;
        for (int i = left; i <= right; i++) {
            // choose one within the range
            int maxCoins = nums[left - 1] * nums[i] * nums[right + 1];
            int maxCoinsLeft = getMaxCoinsInRange(nums, left, i - 1);
            int maxCoinsRight = getMaxCoinsInRange(nums, i + 1, right);
            res = Math.max(res, maxCoins + maxCoinsLeft + maxCoinsRight);
        }

        memo[left][right] = res;

        return res;
    }
}
