package LC1151;

/**
 * LC 1151. Minimum Swaps to Group All 1's Together
 */
public class Solution {
    public int minSwaps(int[] data) {
        int totalOnes = 0;
        for (int num : data) {
            if (num == 1) {
                totalOnes++;
            }
        }

        // sliding window
        // initial window
        int count = 0;
        for (int i = 0; i < totalOnes; i++) {
            if (data[i] == 1) {
                count++;
            }
        }
        int maxCount = count;
        for (int i = totalOnes; i < data.length; i++) {
            if (data[i - totalOnes] == 1) {
                count--;
            }
            if (data[i] == 1) {
                count++;
            }
            maxCount = Math.max(maxCount, count);
        }

        return totalOnes - maxCount;
    }
}
