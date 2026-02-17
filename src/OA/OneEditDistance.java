package OA;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OneEditDistance {
    public boolean solution(String s1, String s2) {
        // one edit
        if (Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }

        int i = 0;
        int j = 0;
        int edit = 0;
        int mismatch = 0;
        char[][] tmp = new char[2][2];
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                if (edit == 1) {
                    return false;
                }
                if (mismatch == 2) {
                    return false;
                }
                if (s1.length() == s2.length()) {
                    // mismatch with same length
                    tmp[mismatch][0] = s1.charAt(i++);
                    tmp[mismatch][1] = s2.charAt(j++);
                    mismatch++;
                } else if (s1.length() > s2.length()) {
                    i++; // delete the mismatch char from s1
                    edit++;
                } else {
                    j++; // delete the mismatch char from s2
                    edit++;
                }
            }
        }

        // two string are same / make 1 delete operation
        if ((edit <= 1 && mismatch == 0) || (edit == 0 && mismatch == 1)) {
            return true;
        }

        return tmp[0][0] == tmp[1][1] && tmp[1][0] == tmp[0][1];
    }

    public static void main(String[] args) {
        OneEditDistance stringTest = new OneEditDistance();
        assertTrue(stringTest.solution("abc", "cba"));
        assertTrue(stringTest.solution("abc", "abe"));
        assertTrue(stringTest.solution("abc", "bc"));
        assertTrue(stringTest.solution("ab", "abc"));
        assertFalse(stringTest.solution("abc", "acd"));
        assertFalse(stringTest.solution("abc", "apple"));
    }
}
