package LC1910;

import java.util.Stack;

/**
 * LC 1910. Remove All Occurrences of a Substring
 */
public class Solution3 {
    public String removeOccurrences(String s, String part) {
        // KMP
        int[] KMP_LPS = computeLongestPrefixSuffix(part);
        Stack<Character> stack = new Stack<>();
        int[] patternIndices = new int[s.length() + 1];

        for (int sIndex = 0, pIndex = 0; sIndex < s.length(); sIndex++) {
            char c = s.charAt(sIndex);
            stack.push(c);

            if (c == part.charAt(pIndex)) {
                patternIndices[stack.size()] = ++pIndex;
                if (pIndex == part.length()) {
                    // match the part string
                    while (pIndex > 0) {
                        stack.pop();
                        pIndex--;
                    }

                    pIndex = stack.isEmpty() ? 0 : patternIndices[stack.size()];
                }
            } else {
                // mismatch
                if (pIndex > 0) {
                    // use KMP to find next
                    sIndex--;
                    pIndex = KMP_LPS[pIndex - 1];
                    stack.pop();
                } else {
                    patternIndices[stack.size()] = 0;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }

    private int[] computeLongestPrefixSuffix(String pattern) {
        // KMP LPS array
        // A B A B C A B A B
        // 0 0 1 2 0 1 2 3 4
        int[] lps = new int[pattern.length()];
        int cur = 1; // lps[0] = 0, so cur start from 1
        int prefixLen = 0;
        while (cur < pattern.length()) {
            if (pattern.charAt(cur) == pattern.charAt(prefixLen)) {
                lps[cur] = ++prefixLen;
                cur++;
            } else if (prefixLen > 0) {
                prefixLen = lps[prefixLen - 1];
            } else {
                lps[cur] = 0;
                cur++;
            }
        }

        return lps;
    }
}
