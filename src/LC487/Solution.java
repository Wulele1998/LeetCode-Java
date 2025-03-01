package LC487;

/**
 * LC 487. Max Consecutive Ones II
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // DP
        // N: the length of nums
        // time: O(N)
        // space: O(1)
        int n = nums.length;
        int prevDP = 0;
        int curDP = 0;
        int prevZeroIndex = 0;
        int countOne = 0;

        //        [1, 0, 1, 1, 0]
        // dp: [0, 1, 2, 3, 4, 4]
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] == 0) {
                int prevOneNumber = i - prevZeroIndex - 1;
                countOne = prevOneNumber + 1;
                prevZeroIndex = i;
            } else {
                countOne++;
            }
            curDP = Math.max(prevDP, countOne);
            prevDP = curDP;
        }

        return prevDP;
    }
}
