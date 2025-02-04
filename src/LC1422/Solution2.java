package LC1422;

public class Solution2 {
    public int maxScore(String s) {
        int n = s.length();
        int[] countZero = new int[n + 1];
        int[] countOne = new int[n + 1];
        int res = 0;
        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if (s.charAt(i - 1) == '0'){
                count++;
            }
            countZero[i] = count;
        }

        count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                count++;
            }
            countOne[i] = count;
        }


        for (int i = 1; i < n; i++) {
            res = Math.max(res, countZero[i] + countOne[i]);
        }

        return res;
    }
}
