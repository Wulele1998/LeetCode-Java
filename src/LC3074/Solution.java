package LC3074;

import java.util.Arrays;

/**
 * Dec 24, 2025
 * LC 3074. Apple Redistribution into Boxes
 */
public class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        // Greedy
        // N: the size of `apple`
        // time: O(N log N)
        // space: Java use quick sort, which is O(log N) in average and O(N) in worst case
        // the distribution starts from the largest capacity
        Arrays.sort(capacity);

        int appleSum = 0;
        for (int app : apple) {
            appleSum += app;
        }

        int index = capacity.length - 1;
        int usedBox = 0;

        while (appleSum > 0 && index >= 0) {
            appleSum -= capacity[index--];
            usedBox++;
        }

        return appleSum > 0 ? -1 : usedBox;
    }
}
