package LC344;

/**
 * LC 344: Reverse String
 */
public class Solution {
    public void reverseString(char[] s) {
        // two pointers
        // N: the length of `s`
        // time: O(N)
        // space: O(1)
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
