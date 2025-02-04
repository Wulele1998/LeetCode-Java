package LC2960;

public class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        // N: the length of `batteryPercentages`
        // time: O(N ^ 2)
        // space: O(1)
        int n = batteryPercentages.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (batteryPercentages[i] > 0) {
                count++;
                for (int j = i + 1; j < n; j++) {
                    if (batteryPercentages[j] > 0)
                        batteryPercentages[j]--;
                }
            }    
        }

        return count;
    }
}
