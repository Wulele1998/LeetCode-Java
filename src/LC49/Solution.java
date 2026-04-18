package LC49;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // N: the length of `strs`
        // K: the length of each string
        // time: O(N * K)
        // space: O(N * K)
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] arr = new int[26];
            for (char c : s.toCharArray()) {
                arr[c - 'a']++;
            }
            String arrStr = Arrays.toString(arr);
            map.computeIfAbsent(arrStr, _ -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
