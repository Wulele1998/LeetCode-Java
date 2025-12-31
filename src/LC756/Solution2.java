package LC756;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LC 756. Pyramid Transition Matrix
 */

public class Solution2 {
    Map<String, List<Character>> allowedMap;
    Map<String, Boolean> memo;

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        // backtrack
        allowedMap = new HashMap<>();
        memo = new HashMap<>();

        for (String s : allowed) {
            String allowedKey = s.substring(0, 2);
            Character allowedVal = s.charAt(2);
            allowedMap.computeIfAbsent(allowedKey, key -> new ArrayList<>()).add(allowedVal);
        }

        return solve(bottom);
    }

    private boolean solve(String bottom) {
        // base case
        if (bottom.length() == 1) {
            return true;
        }

        // check cache
        if (memo.containsKey(bottom)) {
            return memo.get(bottom);
        }

        memo.put(bottom, backtrack(bottom, new StringBuilder(), 0));
        return memo.get(bottom);
    }

    private boolean backtrack(String bottom, StringBuilder newRow, int index) {
        if (index == bottom.length() - 1) {
            // we have traverse the `bottom` string and need to go to next level
            return solve(newRow.toString());
        }

        String key = bottom.substring(index, index + 2);
        for (char c : allowedMap.getOrDefault(key, new ArrayList<>())) {
            newRow.append(c);
            if (backtrack(bottom, newRow, index + 1)) {
                return true;
            }

            // move back and attempt other match
            newRow.deleteCharAt(newRow.length() - 1);
        }

        return false;
    }
}
