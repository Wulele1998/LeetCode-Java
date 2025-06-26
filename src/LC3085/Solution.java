package LC3085;

import java.util.HashMap;

/**
 * LC 3085. Minimum Deletions to Make String K-Special
 */
public class Solution {
    public int minimumDeletions(String word, int k) {
        // N: the length of the word
        // time: O(N + C ^ 2). C = 26
        // space: O(C)
        HashMap<Character, Integer> freq = new HashMap<>();
        int res = word.length();
        for (char c : word.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (int val : freq.values()) {
            int count = 0;
            for (int num : freq.values()) {
                if (val > num) {
                    count += num; // all num need to be deleted
                } else if (num > val + k) {
                    count += num - val - k;
                }
            }

            res = Math.min(res, count);
        }

        return res;
    }
}
