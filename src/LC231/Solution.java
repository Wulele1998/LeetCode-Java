package LC231;

public class Solution {
    public boolean isPowerOfTwo(int n) {
        // time: O(log N)
        // space: O(1)
        if (n < 1)
            return false;
        if (n == 1)
            return true;
        while (n > 1) {
            if (n % 2 != 0)
                return false;
            n /= 2;
        }

        return true;
    }
}
