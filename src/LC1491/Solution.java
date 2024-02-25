package LC1491;

public class Solution {
    public double average(int[] salary) {
        // N: the length of `salary`
        // time: O(N)
        // space: O(1)

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num : salary) {
            sum += num;
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        return (sum - max - min) * 1.0 / (salary.length - 2);
    }
}
