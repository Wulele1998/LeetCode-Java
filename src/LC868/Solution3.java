package LC868;

public class Solution3 {
    public int binaryGap(int n) {
        // one pass
        int res = 0;
        int prev = -1;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) != 0) {
                if (prev != -1) {
                    res = Math.max(res, i - prev);
                }
                prev = i;
            }
        }

        return res;
    }
}
