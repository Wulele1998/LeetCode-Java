package OA;

public class TwoSubarray {
    public int solutionTwoPasses(int[] nums) {
        // can sub array be empty
        // prefix sum
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return -1;
        }

        int n = nums.length;
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            leftSum += nums[i]; // make sure if the subarray can be empty
            if (sum == leftSum * 2) {
                return i; // [0, left] [left + 1, n - 1]
            }
        }

        return -1;
    }

    public int solutionOnePass(int[] nums) {
        // `nums` need to be all positive
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int leftSum = 0;
        int rightSum = 0;

        while (left < right - 1) {
            if (leftSum < rightSum) {
                leftSum += nums[left++];
            } else {
                rightSum += nums[right--];
            }
        }

        return leftSum == rightSum ? left : -1;
    }
}
