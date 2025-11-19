package LC717;

/**
 * Nov 18, 2025
 * LC 717. 1-bit and 2-bit Characters
 */
public class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        // N: the length of `bits`
        // time: O(N)
        // space: O(1)
        for (int i = 0; i < bits.length - 1; i++) {
            if (bits[i] == 1) {
                if (i == bits.length - 2) {
                    return false;
                }
                i++;
            }
        }

        return true;
    }
}
