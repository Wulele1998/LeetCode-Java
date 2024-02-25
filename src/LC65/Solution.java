package LC65;

public class Solution {
    public boolean isNumber(String s) {
        // N: the length of `s`
        // time: O(N)
        // space: O(1)
        int n = s.length();
        boolean seenDigit = false;
        boolean seenExponent = false; // can only have one E or e
        boolean seenDot = false; // can only have one dot

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == '+' || c == '-') {
                // + - can only be the first character or the next one behind e or E
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')
                    return false;
            } else if (c == 'E' || c == 'e') {
                if (seenExponent || !seenDigit)
                    // second time of (E or e) or there is no digit before (E or e)
                    return false;
                seenExponent = true;
                seenDigit = false; // (E or e) must be followed by an Integer number
            } else if (c == '.') {
                if (seenDot || seenExponent)
                    return false;
                seenDot = true;
            } else {
                return false;
            }
        }

        return seenDigit;
    }    
}
