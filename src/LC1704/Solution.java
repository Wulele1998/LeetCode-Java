package LC1704;

import java.util.HashSet;

public class Solution {
    public boolean halvesAreAlike(String s) {
        HashSet<Character> set = new HashSet<>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }};
        int n = s.length();
        int left = 0;
        int right = 0;
        for (int i = 0; i < n / 2; i++) {
            if (set.contains(s.charAt(i))) {
                left++;
            }
            if (set.contains(s.charAt(n / 2 + i))) {
                right++;
            }
        }
        return left == right;
    }
}
