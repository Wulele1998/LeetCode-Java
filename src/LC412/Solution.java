package LC412;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 412. Fizz Buzz
 */
public class Solution {
    public List<String> fizzBuzz(int n) {
        // time: O(N)
        // space: O(1)
        List<String> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }

        return list;
    }
}
