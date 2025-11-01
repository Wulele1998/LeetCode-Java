package LC3136;

import java.util.HashSet;

/**
 * LC 3136. Valid Word
 */
public class Solution {
    public boolean isValid(String word) {
        int vowelCount = 0;
        int consonantCount = 0;
        HashSet<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');
        vowelSet.add('A');
        vowelSet.add('E');
        vowelSet.add('I');
        vowelSet.add('O');
        vowelSet.add('U');

        for (char c : word.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
            if (vowelSet.contains(c)) {
                vowelCount++;
            } else if (!Character.isDigit(c)) {
                consonantCount++;
            }
        }

        return vowelCount >= 1 && consonantCount >= 1;
    }
}
