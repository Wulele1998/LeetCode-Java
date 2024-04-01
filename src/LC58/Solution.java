package LC58;

/**
 * LC 58. Length of Last Word
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        // N: the length of `s`
        // time: O(N)
        // space: O(1)
        int n = s.length();
        int index = n - 1;
        
        while (index >= 0 && s.charAt(index) == ' ') {
            // end with a space
            index--;
        }
        
        for (int i = index; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                // the word is [i + 1, index]
                return index - i;
            }
        }

        // the word is [0, index]
        return index + 1;
    }
}