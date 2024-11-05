package LC459;

public class Solution3 {
    public boolean repeatedSubstringPattern(String s) {
        // Math
        String t = s + s;

        return t.substring(1, t.length() - 1).contains(s);
    }
}
