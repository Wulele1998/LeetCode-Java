package LC49;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // N: the length of `strs`
        // K: the length of each string
        // time: O(N * K * logK)
        // space: O(N * K)
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String sortedStr = new String(charArr);
            res.computeIfAbsent(sortedStr, _ -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(res.values());
    }
}
