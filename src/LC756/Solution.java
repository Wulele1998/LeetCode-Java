package LC756;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Dec 29, 2025
 * LC 756. Pyramid Transition Matrix
 */
public class Solution {
    Map<String, List<Character>> allowedMap;
    Map<String, Boolean> memo;

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        // backtrack
        // N: the length of `bottom`
        // K: the size of the alphabet
        // time: O (K ^ (N ^ 2))
        // space: O(K ^ N *  N)
        allowedMap = new HashMap<>();
        memo = new HashMap<>();

        // time: O(M)
        // space: O(M)
        for (String s : allowed) {
            String allowedKey = s.substring(0, 2);
            Character allowedVal = s.charAt(2);
            allowedMap.computeIfAbsent(allowedKey, key -> new ArrayList<>()).add(allowedVal);
        }

        return backtrack(bottom, new StringBuilder(), 0);
    }

    private boolean backtrack(String bottom, StringBuilder nextRow, int index) {
        if (bottom.length() == 1) {
            return true;
        }

        if (index == bottom.length() - 1) {
            if (memo.containsKey(nextRow.toString())) {
                return memo.get(nextRow.toString());
            }
            // complete the current row, go next
            memo.put(nextRow.toString(), backtrack(nextRow.toString(), new StringBuilder(), 0));

            return memo.get(nextRow.toString());
        }

        String key = bottom.substring(index, index + 2);
        for (Character c : allowedMap.getOrDefault(key, new ArrayList<>())) {
            nextRow.append(c);
            if (backtrack(bottom, nextRow, index + 1)) {
                return true;
            }

            // backtrack and attempt next available key
            nextRow.deleteCharAt(nextRow.length() - 1);
        }

        return false;
    }
}
