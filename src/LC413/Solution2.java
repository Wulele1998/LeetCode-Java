package LC413;

public class Solution2 {
    public int numberOfArithmeticSlices(int[] nums) {
        // better brute force
        // N: the length of `nums`
        // time: O(N ^ 2)
        // space: O(1)
        int n = nums.length;
        int res = 0;

        // subarray [i, j]
        for (int i = 0; i < n - 2; i++) {
            int diff = nums[i + 1] - nums[i];
            for (int j = i + 2; j < n; j++) {
                if (nums[j] - nums[j - 1] == diff) {
                    res++;
                } else {
                    break;
                }
            }
        }

        return res;
    }
}
