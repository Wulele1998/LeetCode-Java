package LC989;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        // N: the length of `num`
        // time: O(max(N, log K))
        // space: O(max(N, log K))
        LinkedList<Integer> res = new LinkedList<>();
        int n = num.length;
        int carry = 0;
        for (int i = n - 1; i >= 0; i--) {
            int digit = 0;
            if (k > 0) {
                digit = k % 10;
                k /= 10;
            }
            int sum = num[i] + digit + carry;
            res.addFirst(sum % 10);
            carry = sum / 10;
        }

        while (k > 0) {
            int sum = carry + k % 10;
            k /= 10;
            res.addFirst(sum % 10);
            carry = sum / 10;
        }

        if (carry != 0) {
            res.addFirst(carry);
        }

        return res;
    }
}
