package LC1128;

import java.util.HashMap;

public class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        // time: O(N)
        // space: O(N)
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int[] domino : dominoes) {
            int key = Math.min(domino[0], domino[1]) * 10 + Math.max(domino[0], domino[1]);
            res += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return res;
    }
}
