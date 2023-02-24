package LC413;

public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        // brute force
        // N: the length of `nums`
        // time: O(N ^ 3)
        // space: O(1)
        int n = nums.length;
        int res = 0;

        for (int start = 0; start < n - 2; start++) {
            int diff = nums[start + 1] - nums[start];
            for (int end = start + 2; end < n; end++) {
                int i = start + 2;
                for (; i <= end; i++) {
                    if (nums[i] - nums[i - 1] != diff) {
                        break;
                    }
                }
                if (i > end) {
                    res++;
                }
            }
        }

        return res;
    }
}
