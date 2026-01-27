package LC66;

/**
 * Jan 1, 2026
 * LC 66. Plus One
 */
public class Solution2 {
    public int[] plusOne(int[] digits) {
        // N: the length of `digits`
        // time: O(N)
        // space: O(N)
        int n = digits.length;
        int index = n - 1;
        while (index >= 0 && digits[index] == 9 ) {
            digits[index] = 0;
            index--;
        }
        if (index != -1) {
            digits[index]++;
            return digits;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        System.arraycopy(digits, 0, res, 1, n);

        return res;
    }
}
