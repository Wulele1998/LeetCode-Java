package LC67;

public class Solution2 {
    public String addBinary(String a, String b) {
        // not necessary to reverse the string at start
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int digitA = i >= 0 ? a.charAt(i) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = digitA + digitB + carry;
            carry = sum / 2;
            res.append(sum % 2);
            i--;
            j--;
        }
        if (carry != 0)
            res.append(carry);

        return res.reverse().toString();
    }
}
