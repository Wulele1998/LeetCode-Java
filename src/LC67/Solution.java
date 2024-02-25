package LC67;

import java.util.LinkedList;

public class Solution {
    public String addBinary(String a, String b) {
        // M: the length of `a`
        // N: the length of `b`
        // time: O(max(M, N))
        // space: O(max(M, N))
        int m = a.length();
        int n = b.length();
        int carry = 0;
        LinkedList<Integer> res = new LinkedList<>();
        // reverse operation takes O(M)
        String aRev = new StringBuilder(a).reverse().toString();
        // reverse operation takes O(N)
        String bRev = new StringBuilder(b).reverse().toString();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Math.max(m, n); i++) {
            int val1 = i < m ? aRev.charAt(i) - '0' : 0;
            int val2 = i < n ? bRev.charAt(i) - '0' : 0;
            int sum = val1 + val2 + carry;
            res.addFirst(sum % 2);
            carry = sum / 2;
        }

        if (carry == 1) {
            res.addFirst(1);
        }

        for (int digit : res) {
            sb.append(digit);
        }

        return sb.toString();
    }
}
