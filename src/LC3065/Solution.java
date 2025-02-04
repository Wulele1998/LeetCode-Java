package LC3065;

/**
 * LC 3065. Minimum Operations to Exceed Threshold Value I
 */
public class Solution {
    public int minOperations(int[] nums, int k) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(1)
        int res = 0;
        
        for (int num : nums) {
            if (num < k) {
                res++;
            }
        }   

        return res;
    }    
}
