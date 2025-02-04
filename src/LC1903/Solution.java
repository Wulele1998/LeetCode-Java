package LC1903;

public class Solution {
    public String largestOddNumber(String num) {
        // N: the length of `num`
        // time: O(N)
        // space: O(1)
        char[] nums = num.toCharArray();
        int n = nums.length;

        for (int i = n - 1; i >= 0; i--) {
            int digit = nums[i] - '0';
            if ((digit & 1) == 1) {
                return num.substring(0, i + 1);
            }
        }

        return "";
    }
}
