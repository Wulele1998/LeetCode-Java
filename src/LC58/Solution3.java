package LC58;

/**
 * LC 58. Length of Last Word
 */
public class Solution3 {
    public int lengthOfLastWord(String s) {
        // N: the length of `s`
        // time: O(N)
        // space: O(1)
        int index = s.length() - 1;
        int len = 0;

        while (index >= 0) {
            if (s.charAt(index) != ' ') {
                len++;
            } else if (len != 0) {
                // get the last one word
                return len;
            }
            index--;
        }

        return len;
    }
}
