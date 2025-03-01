package LC1910;

/**
 * LC 1910. Remove All Occurrences of a Substring
 */
public class Solution2 {
    public String removeOccurrences(String s, String part) {
        // M: the size of `part`
        // N: the size of `s`
        // time: O(N + M)
        // space: O(N + M)
        char[] partChars = part.toCharArray();
        char[] inputChars = s.toCharArray();
        char[] stackChars = new char[s.length()];
        int stackSize = 0;
        int n = partChars.length;

        for (char c : inputChars) {
            stackChars[stackSize++] = c;
            if (c == partChars[n - 1] && stackSize >= n) {
                // start to match
                int i = stackSize - 1;
                int j = n - 1;
                // i >= j
                while (j >= 0 && stackChars[i] == partChars[j]) {
                    i--;
                    j--;
                }
                if (j < 0) {
                    // part string matched the stack string
                    stackSize = i + 1;
                }
            }
        }

        return String.valueOf(stackChars, 0, stackSize);
    }
}
