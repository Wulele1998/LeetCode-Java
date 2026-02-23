package LC868;

/**
 * Feb 23, 2026
 * LC 868. Binary Gap
 */
public class Solution {
    public int binaryGap(int n) {
        // time: O(log N)
        // space: O(log N)
        String binary = Integer.toBinaryString(n);
        int prev = 0;
        int dist = 0;

        for (int i = 1; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                dist = Math.max(dist, i - prev);
                prev = i;
            }
        }

        return dist;
    }
}
