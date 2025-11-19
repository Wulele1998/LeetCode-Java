package LC1437;

public class Solution3 {
    public boolean kLengthApart(int[] nums, int k) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(1)
        int count = k; // for the first 1
        for (int num : nums) {
            if (num == 1) {
                if (count < k) {
                    return false;
                }
                count = 0; // reset the count
            } else {
                count++; // count the distance between 1
            }
        }

        return true;
    }
}
