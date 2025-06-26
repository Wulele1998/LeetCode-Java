package LC3170;

import java.util.Stack;

/**
 * LC 3170. Lexicographically Minimum String After Removing Stars
 */
public class Solution {
    // N: the length of string
    // time: O(N)
    // space: O(N)
    public String clearStars(String s) {
        Stack<Integer>[] letterStacks = new Stack[26];
        for (int i = 0; i < 26; i++) {
            letterStacks[i] = new Stack<>();
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c != '*') {
                letterStacks[c - 'a'].push(i);
            } else {
                // find the '*'
                // remove the smallest
                for (int j = 0; j < 26; j++) {
                    if (!letterStacks[j].isEmpty()) {
                        chars[letterStacks[j].pop()] = '#';
                        break;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c != '*' && c != '#') {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
