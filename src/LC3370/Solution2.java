package LC3370;

/**
 * Oct 29, 2025
 * LC 3370. Smallest Number With All Set Bits
 */
public class Solution2 {
    public int smallestNumber(int n) {
        // time: O(log N)
        // space: O(1)
        int x = 1;
        // 1, 3, 7, 15
        while (x < n) {
            x = x * 2 + 1;
        }

        return x;
    }
}
