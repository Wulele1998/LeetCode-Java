package LC1910;

/**
 * LC 1910. Remove All Occurrences of a Substring
 */
public class Solution {
    public String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            // the time complexity of `indexOf` is O(M * N)
            int index = s.indexOf(part);
            s = s.substring(0, index) + s.substring(index + part.length());
        }

        return s;
    }
}
