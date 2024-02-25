package LC1716;

public class Solution {
    public int totalMoney(int n) {
        // time: O(1)
        // space: O(1)
        int week = n / 7;
        int left = n % 7;
        if (week == 0) {
            return (1 + left) * n / 2;
        }
        int SUM = 28;

        int days = (SUM + (SUM + 7 * (week - 1))) * week / 2;
        days += (week + 1 + week + left) * left / 2;

        return days;
    }
}
