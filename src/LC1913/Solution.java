package LC1913;

public class Solution {
    public int maxProductDifference(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(1)
        int biggest = Math.max(nums[0], nums[1]);
        int secondBiggest = Math.min(nums[0], nums[1]);
        int smallest = secondBiggest;
        int secondSmallest = biggest;
        int n = nums.length;

        for (int i = 2; i < n; i++) {
            if (nums[i] >= biggest) {
                secondBiggest = biggest;
                biggest = nums[i];
            } else if (nums[i] > secondBiggest) {
                secondBiggest = nums[i];
            }
            if (nums[i] <= smallest) {
                secondSmallest = smallest;
                smallest = nums[i];
            } else if (nums[i] < secondSmallest) {
                secondSmallest = nums[i];
            }
        }

        return biggest * secondBiggest - smallest * secondSmallest;
    }
}
