package LC2000;

/**
 * LC 2000. Reverse Prefix of Word
 */

public class Solution {
    public String reversePrefix(String word, char ch) {
        // N: the length of `word`
        // time: O(N)
        // space: O(1)
        char[] chars = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if (chars[i] == ch) {
                reverse(chars, 0, i);
                return new String(chars);
            }
        }

        return word;
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
