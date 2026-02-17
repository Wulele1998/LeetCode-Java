package LC190;

/**
 * Feb 16， 2026
 * LC 190. Reverse Bits
 */
public class Solution {
    public int reverseBits(int n) {
        String binary = Integer.toBinaryString(n);
        int padding = 32 - binary.length();
        int base = 1;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (i >= padding && binary.charAt(i - padding) == '1') {
                res += base;
            }

            base <<= 1;
        }

        return res;
    }
}
