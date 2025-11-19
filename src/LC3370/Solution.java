package LC3370;

/**
 * Oct 29, 2025
 * LC 3370. Smallest Number With All Set Bits
 */
public class Solution {
    public int smallestNumber(int n) {
        // time: O(log N)
        // space: O(log N)
        String binaryN = Integer.toBinaryString(n);
        for (int i = 0; i < binaryN.length(); i++) {
            if (binaryN.charAt(i) == '0') {
                n += (1 << binaryN.length() - i - 1);
            }
        }

        return n;
    }
}
