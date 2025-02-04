package LC43;

public class Solution {
    public String multiply(String num1, String num2) {
        // M: the length of `num1`
        // N: the length of `num2`
        // time: O(M * N)
        // space: O(M + N)
        // special case
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length(), n = num2.length();
        int[] res = new int[n + m];
        StringBuilder sb = new StringBuilder();

        for (int i = m - 1; i >= 0; i--) {
            int val1 = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int val2 = num2.charAt(j) - '0';
                // get the index of current digit
                int index = i + j + 1;
                int product = val1 * val2 + res[index];
                res[index] = product % 10;
                res[index - 1] += product / 10;
            }
        }

        int startIndex = res[0] == 0 ? 1 : 0;
        for (int i = startIndex; i < m + n; i++) {
            sb.append(res[i]);
        }

        return sb.toString();
    }
}
