package LC963;

/**
 * Feb 18, 2026
 * LC 693. Binary Number with Alternating Bits
 */
public class Solution {
    public boolean hasAlternatingBits(int n) {
        String binary = Integer.toBinaryString(n);
        for (int i = 0; i < binary.length() - 1; i++) {
            if (binary.charAt(i) == binary.charAt(i + 1)) {
                return false;
            }
        }

        return true;
    }
}
