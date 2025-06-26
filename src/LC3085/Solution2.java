package LC3085;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * LC 3085. Minimum Deletions to Make String K-Special
 */
public class Solution2 {
    public int minimumDeletions(String word, int k) {
        // N: the length of the word
        // time: O(N + C ^ 2). C = 26
        // space: O(C)
        HashMap<Character, Integer> freq = new HashMap<>();
        int res = word.length();
        for (char c : word.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        List<Integer> freqValues = new ArrayList<>(freq.values());
        Collections.sort(freqValues);

        for (int i = 0; i < freqValues.size(); i++) {
            int count = 0;
            for (int j = freqValues.size() - 1; j > i; j--) {
                if (freqValues.get(j) - freqValues.get(i) <= k) {
                    break;
                }
                count += freqValues.get(j) - freqValues.get(i) - k;
            }

            res = Math.min(res, count);
        }

        return res;
    }
}
