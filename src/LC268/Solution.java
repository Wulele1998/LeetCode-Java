package LC268;

public class Solution {
    public int missingNumber(int[] nums) {
        // N: the length of num
        // time: O(N)
        // space: O(1)
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        for (int num : nums)
            sum -= num;

        return sum;
    }
}
