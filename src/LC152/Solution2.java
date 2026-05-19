package LC152;

import java.util.Arrays;

public class Solution2 {
    public static final int INF = Integer.MAX_VALUE;
    // memo[i][0]: maximum positive product subarray start from nums[i]
    // memo[i][1]: minimum negative product subarray start from nums[i]
    private int[][] memo;
    public int maxProduct(int[] nums) {
        int n = nums.length;
        memo = new int[n][2];
        for (int[] memoRow : memo) {
            Arrays.fill(memoRow, INF);
        }

        int res = memo[0][0];
        for (int i = 1; i < n; i++) {
            res = Math.max(memo[i][0], res);
        }

        return res;
    }

    private int topDownDPHelper(int[] nums, int index, int isNeg) {
        // base case
        if (index == nums.length) {
            return 1;
        }

        if (memo[index][isNeg] != INF) {
            return memo[index][isNeg];
        }

        if (nums[index] >= 0) {
            memo[index][0] = nums[index] * topDownDPHelper(nums, index, 0);
            memo[index][1] = nums[index] * topDownDPHelper(nums, index, 1);
        } else {
            memo[index][0] = nums[index] * topDownDPHelper(nums, index, 1);
            memo[index][1] = nums[index] * topDownDPHelper(nums, index, 0);
        }

        return memo[index][isNeg];
    }
}
