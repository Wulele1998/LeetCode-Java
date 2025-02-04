package LC2574;

public class Solution {
    public int[] leftRightDifference(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(N)
        int n = nums.length;
        int[] res = new int[n];

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int[] suffix = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            res[i] = Math.abs(prefix[i] - suffix[i + 1]);
        }

        return res;
    }
}
