package LC389;

public class Solution2 {
    public char findTheDifference(String s, String t) {
        // N: the length of `s`
        // time: O(N)
        // space: O(1)
        int n = s.length();
        int sum = t.charAt(s.length());

        for (int i = 0; i < n; i++) {
            sum += t.charAt(i) - s.charAt(i);
        }

        return (char) sum;
    }
}