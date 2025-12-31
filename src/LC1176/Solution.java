package LC1176;

public class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int sum = 0;
        int point = 0;
        for (int i = 0; i < k; i++) {
            sum += calories[i];
        }
        if (sum < lower) {
            point--;
        } else if (sum > upper) {
            point++;
        }
        for (int i = k; i < calories.length; i++) {
            sum += calories[i];
            sum -= calories[i - k];
            if (sum < lower) {
                point--;
            } else if (sum > upper) {
                point++;
            }
        }

        return point;
    }
}
