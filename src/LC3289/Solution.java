package LC3289;

/**
 * Oct 31, 2025
 * LC 3289. The Two Sneaky Numbers of Digitville
 */
public class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        // N: the length of `nums`
        // time: O(N)
        // space: O(N)
        int n = nums.length;
        int[] cache = new int[n - 2];
        int index = 0;
        int[] res = new int[2];

        for (int num : nums) {
            if (cache[num] == 1) {
                res[index++] = num;
                if (index == 2) {
                    return res;
                }
            }
            cache[num]++;
        }

        return res;
    }
}
