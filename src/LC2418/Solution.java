package LC2418;

import java.util.Arrays;
import java.util.HashMap;

/**
 * LC 2418. Sort the People
 */
public class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        // N: the number of people
        // time: O(N * log N)
        // space: O(logN + N)
        HashMap<Integer, String> map = new HashMap<>();
        int n = names.length;
        for (int i = 0; i < n; i++) {
            map.put(heights[i], names[i]);
        }

        Arrays.sort(heights);

        String[] res = new String[n];
        for (int i = n - 1; i >= 0; i--) {
            res[n - 1 - i] = map.get(heights[i]);
        }

        return res;
    }
}
