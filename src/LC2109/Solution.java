package LC2109;

/**
 * LC 2109. Adding Spaces to a String
 */
public class Solution {
    public String addSpaces(String s, int[] spaces) {
        // N: the length of `s`
        // time: O(N)
        // space: O(N)
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            if (j < spaces.length && i == spaces[j]) {
                sb.append(" ").append(s.charAt(i));
                j++;
            } else {
                sb.append(s.charAt(i));
            }
            i++;
        }

        return sb.toString();
    }
}
