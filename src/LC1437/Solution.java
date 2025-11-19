package LC1437;

/**
 * Nov 17, 2025
 * LC 1437. Check If All 1's Are at Least Length K Places Away
 */
public class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 1) {
                for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                    if (nums[j] == 1) {
                        return false;
                    }
                    i = j;
                }
            }
        }

        return true;
    }
}
