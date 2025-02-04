package LC989;

import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        // N: the length of `num`
        // time: O(max(N, log K))
        // space: O(max(N, log K))
        int n = num.length;
        LinkedList<Integer> res = new LinkedList<>();
        int i = n - 1;
        int cur = k;

        while (i >= 0 || cur > 0) {
            if (i >= 0) {
                cur += num[i];
                i--;
            }
            res.addFirst(cur % 10);
            cur /= 10;
        }

        return res;
    }
}
