package LC2490;

/**
 * LC 2490. Circular Sentence
 */
public class Solution {
    public boolean isCircularSentence(String sentence) {
        // N: the length of `sentence`
        // time: O(N)
        // space: O(N)
        String[] strings = sentence.split(" ");
        for (int i = 0; i < strings.length - 1; i++) {
            String first = strings[i];
            String second = strings[i + 1];
            if (first.charAt(first.length() - 1) != second.charAt(0)) {
                return false;
            }
        }

        return strings[0].charAt(0) == strings[strings.length - 1].charAt(strings[strings.length - 1].length() - 1);
    }
}
