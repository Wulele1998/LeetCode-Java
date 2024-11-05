package LC273;

/**
 * LC 273. Integer to English Words
 */
public class Solution {
    final String[] BELOW_TEN = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    final String[] BELOW_TWENTY = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    final String[] BELOW_HUNDRED = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        // time: O(1)
        // space: O(1)
        if (num == 0) {
            return "Zero";
        }

        return convert(num);
    }

    private String convert(int num) {
        if (num < 10) {
            return BELOW_TEN[num];
        }

        if (num < 20) {
            return BELOW_TWENTY[num - 10];
        }

        if (num < 100) {
            return BELOW_HUNDRED[num / 10] + (num % 10 == 0 ? "" : (" " + BELOW_TEN[num % 10]));
        }

        if (num < 1000) {
            return convert(num / 100) + " Hundred" + (num % 100 == 0 ? "" : (" " + convert(num % 100)));
        }

        if (num < 1000_000) {
            return convert(num / 1000) + " Thousand" + (num % 1000 == 0 ? "" : (" " + convert(num % 1000)));
        }

        if (num < 1000_000_000) {
            return convert(num / 1000_000) + " Million" + (num % 1000_000 == 0 ? "" : (" " + convert(num % 1000_000)));
        }

       return convert(num / 1000_000_000) + " Billion" + (num % 1000_000_000 == 0 ? "" :  (" " + convert(num % 1000_000_000)));
    }
}
