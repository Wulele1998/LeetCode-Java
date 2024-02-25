package LC2574;

public class Solution2 {
    public int[] leftRightDifference(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(1)
        int n = nums.length;
        int sumSuffix = 0;
        int sumPrefix = 0;
        int[] res = new int[n];

        for (int num : nums) {
            sumSuffix += num;
        }

        for (int i = 0; i < n; i++) {
            sumSuffix -= nums[i];
            res[i] = Math.abs(sumSuffix - sumPrefix);
            sumPrefix += nums[i];
        }

        return res;
    }
}
