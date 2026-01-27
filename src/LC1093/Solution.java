package LC1093;

/**
 * LC 1093. Statistics from a Large Sample
 */
public class Solution {
    public double[] sampleStats(int[] count) {
        // N: the length of `count`
        // time: O(N)
        // space: O(1)
        int maximum = -1;
        int minimum = 256;
        double sum = 0.0;
        int countNum = 0;
        int maxAppear = 0;
        int maxAppearNum = -1;

        for (int i = 0; i < 256; i++) {
            if (count[i] > 0) {
                maximum = Math.max(maximum, i);
                minimum = Math.min(minimum, i);
                sum += 1.0 * count[i] * i;
                countNum += count[i];
                if (count[i] > maxAppear) {
                    maxAppear = count[i];
                    maxAppearNum = i;
                }
            }
        }

        // calculate the median
        int median1 = -1;
        int median2 = -1;
        int curCount = 0;
        for (int i = minimum; i <= maximum; i++) {
            curCount += count[i];
            if (curCount >= countNum / 2 && median1 == -1) {
                median1 = i;
            }
            if (curCount >= countNum / 2 + 1) {
                median2 = i;
                break;
            }
        }

        if (countNum % 2 == 0) {
            return new double[] {minimum, maximum, sum / countNum, (median1 + median2) / 2.0, maxAppearNum};
        } else {
            return new double[] {minimum, maximum, sum / countNum, median2, maxAppearNum};
        }
    }
}
