package LC2601;

public class Solution {
    public boolean primeSubOperation(int[] nums) {
        // brute force
        // N: the length of `nums`
        // M: the largest value in `nums`
        // time: O(N * M * √M)
        // space: O(1)
        for (int i = 0; i < nums.length; i++) {
            int bound = 0;
            if (i == 0) {
                bound = nums[0];
            } else {
                bound = nums[i] - nums[i - 1];
            }

            if (bound <= 0) {
                return false;
            }

            int largestPrimeLessBound = 0;
            for (int j = bound - 1; j >= 2; j--) {
                if (isPrime(j)) {
                    largestPrimeLessBound = j;
                    break;
                }
            }

            nums[i] -= largestPrimeLessBound;
        }

        return true;
    }

    private boolean isPrime(int num) {
       for (int i = 2; i <= Math.sqrt(num); i++) {
           if (num % i == 0) {
               return false;
           }
       }

       return true;
    }
}
