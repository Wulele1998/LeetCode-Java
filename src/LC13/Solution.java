package LC13;

import java.util.Map;
import java.util.HashMap;
public class Solution {
    public int romanToInt(String s) {
        // N: the length of `s`
        // time: O(N)
        // space: O(1)
        Map<Character, Integer> priorityMap = new HashMap<>();
        priorityMap.put('I', 1);
        priorityMap.put('V', 2);
        priorityMap.put('X', 3);
        priorityMap.put('L', 4);
        priorityMap.put('C', 5);
        priorityMap.put('D', 6);
        priorityMap.put('M', 7);
        Map<Character, Integer> valueMap = new HashMap<>();
        valueMap.put('I', 1);
        valueMap.put('V', 5);
        valueMap.put('X', 10);
        valueMap.put('L', 50);
        valueMap.put('C', 100);
        valueMap.put('D', 500);
        valueMap.put('M', 1000);
        int res = 0;
        char[] digits = s.toCharArray();
        int n = digits.length;

        for (int i = 0; i < n - 1; i++) {
            if (priorityMap.get(digits[i]) < priorityMap.get(digits[i + 1])) {
                res -= valueMap.get(digits[i]);
            } else {
                res += valueMap.get(digits[i]);
            }
        }
        res += valueMap.get(digits[n - 1]);

        return res;
    }
}
