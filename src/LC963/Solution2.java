package LC963;

/**
 * Feb 18, 2026
 * LC 693. Binary Number with Alternating Bits
 */
public class Solution2 {
    public boolean hasAlternatingBits(int n) {
        int prevBit = -1;

        while (n > 0) {
            int curBit = n % 2;
            if (prevBit != -1 && curBit == prevBit) {
                return false;
            }
            n /= 2;
            prevBit = curBit;
        }

        return true;
    }
}
