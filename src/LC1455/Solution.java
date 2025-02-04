package LC1455;

/**
 * LC 1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence
 */
public class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        // N: the number of words in `sentence`
        // M: the length of `searchWord`
        // time: O(N * M)
        // space: O(N)
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) {
                return i + 1;
            }
        }

        return -1;
    }
}
