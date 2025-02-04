package LC1287;

import java.util.HashMap;

public class Solution {
    public int findSpecialInteger(int[] arr) {
        // use HashMap to count the appearance
        // N: the length of `arr`
        // time: O(N)
        // space: O(N), HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int threshold = n / 4;

        for (int num : arr) {
            if (map.getOrDefault(num, 0) >= threshold) {
                return num;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return -1;
    }
}
