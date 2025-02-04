package LC66;

public class Solution {
    public int[] plusOne(int[] digits) {
        // N: the length of digits
        // time: O(N)
        // space: O(N)
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        // need to add 1 digit at the beginning of result
        int[] res = new int[n + 1];
        res[0] = 1;
        System.arraycopy(digits, 0, res, 1, n);

        return res;
    }
}
