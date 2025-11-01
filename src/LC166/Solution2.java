package LC166;

import java.util.HashMap;

/**
 * LC 166. Function to Recurring Decimal
 */

public class Solution2 {
    public String fractionToDecimal(int numerator, int denominator) {
        // time: O(1)
        // space: O(1)
        // corner case
        if (numerator == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-"); // the result is a negative number
        }

        long dividend = Math.abs((long) numerator);
        long divisor = Math.abs((long) denominator);
        result.append(dividend / divisor);
        if (dividend % denominator == 0) {
            return result.toString();
        }
        result.append(".");
        long reminder = dividend % divisor;
        HashMap<Long, Integer> map = new HashMap<>();
        while (reminder != 0) {
            if (map.containsKey(reminder)) {
                // find the loop of numbers
                result.insert(map.get(reminder), "(");
                result.append(")");
                return result.toString();
            }
            // the map stores the key as a reminder and the value as the index
            map.put(reminder, result.length());
            reminder *= 10;
            result.append(reminder / divisor);
            reminder %= divisor; // update the reminder value
        }

        return result.toString();
    }
}
