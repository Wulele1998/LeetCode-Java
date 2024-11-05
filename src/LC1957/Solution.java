package LC1957;

/**
 * LC 1957. Delete Characters to Make Fancy String
 */
public class Solution {
    public String makeFancyString(String s) {
        // N: the length of `s`
        // time: O(N)
        // space: O(N)
        StringBuilder sb = new StringBuilder();

        int count = 1;
        char c = s.charAt(0);
        sb.append(c);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            } else {
                c = s.charAt(i);
                count = 1;
            }

            if (count < 3) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
