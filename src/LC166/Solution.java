package LC166;

import java.util.HashMap;

/**
 * LC 166. Function to Recurring Decimal
 */
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // time: O(1)
        // space: O(1)
        if (numerator == 0) {
            return "0";
        }
        long numL = numerator;
        long denL = denominator;
        boolean flag = true;
        if (numL < 0) {
            flag = !flag;
            numL = -numL;
        }
        if (denL < 0) {
            flag = !flag;
            denL = -denL;
        }

        long numInt = numL / denL;
        long reminder = numL % denL;
        HashMap<Long, Integer> map = new HashMap<>();
        StringBuilder numDecimal = new StringBuilder();
        int index = 0;
        String res = flag ? "" : "-";
        while (reminder % denL != 0) {
            if (map.containsKey(reminder)) {
                // find the loop
                int loopIndex = map.get(reminder);
                String loopString = numDecimal.substring(loopIndex, index);
                String preLoop = numDecimal.substring(0, loopIndex);

                return res + numInt + "." + preLoop + "(" + loopString + ")";
            }
            map.put(reminder, index++);
            reminder = reminder * 10;
            long digit = reminder / denL;
            numDecimal.append(digit);
            reminder = reminder % denL;
        }

        if (numDecimal.isEmpty()) {
            return res + numInt;
        } else {
            return res + numInt + "." + numDecimal;
        }
    }
}
