package LC58;

public class Solution {
    public int lengthOfLastWord(String s) {
        // N: the length of `s`
        // time: O(N)
        // space: O(1)
        int n = s.length();
        int index = n - 1;
        
        while (s.charAt(index) == ' ' && index >= 0) {
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