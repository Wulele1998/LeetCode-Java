package LC201;

public class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        // time: O(1)
        // space: O(1)
        int shift = 0;

        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }

        return left << shift;
    }
}
