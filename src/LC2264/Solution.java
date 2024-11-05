package LC2264;

public class Solution {
    public String largestGoodInteger(String num) {
        // N: the length of `num`
        // time: O(N)
        // space: O(1)
        int n = num.length();
        char[] numChars = num.toCharArray();

        int count = 1;
        int digit = '0' - 1;
        int index = 1;

        while (index < n) {
            while (index < n && numChars[index] == numChars[index - 1]) {
                count++;
                if (count == 3) {
                    count = 0;
                    digit = Math.max(digit, numChars[index]);
                }
                index++;
            }
            count = 1;
            index++;
        }

        if (digit == '0' - 1) {
            return "";
        }

        return String.valueOf((char) digit).repeat(3);
    }
}
