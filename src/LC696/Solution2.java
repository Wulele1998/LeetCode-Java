package LC696;

public class Solution2 {
    public int countBinarySubstrings(String s) {
        int res = 0;
        int prevCount = 0;
        int curCount = 1; // the first char
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curCount++;
            } else {
                res += Math.min(prevCount, curCount);
                prevCount = curCount;
                curCount = 1;
            }
        }

        res += Math.min(prevCount, curCount);

        return res;
    }
}
