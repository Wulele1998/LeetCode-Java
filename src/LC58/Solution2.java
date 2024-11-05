package LC58;

/**
 * LC 58. Length of Last Word
 */
public class Solution2 {
    public int lengthOfLastWord(String s) {
        // time: O(N)
        // space: O(N)
        s = s.trim();
        String[] strings = s.split(" ");
        return strings[strings.length - 1].length();
    }
}
