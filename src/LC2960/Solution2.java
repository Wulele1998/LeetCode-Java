package LC2960;

public class Solution2 {
    public int countTestedDevices(int[] batteryPercentages) {
        // N: the length of `batteryPercentages`
        // time: O(N)
        // space: O(1)
        int count = 0;

        for (int batteryPercentage : batteryPercentages) {
            if (batteryPercentage > count) {
                count++;
            }
        }

        return count;
    }
}
