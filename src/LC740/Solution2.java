package LC740;

import java.util.HashMap;

public class Solution2 {
    public int deleteAndEarn(int[] nums) {
        // Dynamic Programming optimized space
        // N: the length of `nums`
        // K: the max number in `nums`
        // time: O(N + K)
        // space: O(N), N for the hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxNum = 0;

        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            map.put(num, map.getOrDefault(num, 0) + num);
        }
        // base case
        int first = 0;
        int second = 0;
        for (int i = 1; i < maxNum + 1; i++) {
            int next = Math.max(first + map.getOrDefault(i, 0), second);
            first = second;
            second = next;
        }

        return second;
    }
}
