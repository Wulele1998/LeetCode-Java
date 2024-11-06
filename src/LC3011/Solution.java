package LC3011;

public class Solution {
    public boolean canSortArray(int[] nums) {
        // bubble sort
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                   if (Integer.bitCount(nums[j]) == Integer.bitCount(nums[j + 1])) {
                       int temp = nums[j];
                       nums[j] = nums[j + 1];
                       nums[j + 1] = temp;
                   } else {
                       return false;
                   }
                }
            }
        }

        return true;
    }
}
