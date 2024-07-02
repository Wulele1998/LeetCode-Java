package LC881;

import java.util.Arrays;

/**
 * LC 81. Boats to Save People
 */

public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // two pointers
        // N: the length of `people`
        // time: O(N * logN)
        // space: O(logN)
        Arrays.sort(people);

        int i = 0;
        int j = people.length - 1;
        int boat = 0;

        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
            boat++;
        }

        return boat;
    }
}
