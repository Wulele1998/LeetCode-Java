package LC1991;

public class Solution {
    public int findMiddleIndex(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(N)
        int n = nums.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            if (leftSum[i] == rightSum[i])
                return i;
        }

        return -1;
    }
}
