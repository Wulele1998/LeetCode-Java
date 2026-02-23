package LC868;

public class Solution2 {
    public int binaryGap(int n) {
        int[] indices = new int[32];
        int index = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) != 0) {
                indices[index++] = i;
            }
        }

        int res = 0;
        for (int i = 0; i < index - 1; i++) {
            res = Math.max(res, indices[i + 1] - indices[i]);
        }

        return res;
    }
}
