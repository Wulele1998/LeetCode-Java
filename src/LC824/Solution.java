package LC824;

/**
 * LC 824. Goat Latin
 */
public class Solution {
    public String toGoatLatin(String sentence) {
        // time: O(N)
        // space: O(N)
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        int n = words.length;
        for (int i = 0; i < n; i++) {
            String word = words[i];
            if (isVowel(word.charAt(0))) {
                sb.append(word);
            } else {
                sb.append(word.substring(1));
                sb.append(word.charAt(0));
            }

            sb.append("ma");
            sb.append("a".repeat(i + 1));

            if (i != n - 1) {
                sb.append(' ');
            }
        }

        return sb.toString();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
