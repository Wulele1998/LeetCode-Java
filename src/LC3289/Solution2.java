package LC3289;

/**
 * Oct 31, 2025
 * LC 3289. The Two Sneaky Numbers of Digitville
 */
public class Solution2 {
    public int[] getSneakyNumbers(int[] nums) {
        // require: space O(1)
        // using bit operation

        // N: the length of `nums`
        // time: O(N)
        // space: O(1)
        int n = nums.length - 2;
        // should be 0, 1, 2, 3, ..., n - 1
        int xorSum = 0;
        for (int num : nums) {
            xorSum ^= num;
        }
        for (int i = 0; i < n; i++) {
            xorSum ^= i;
        }

        // assume 2 duplicate number is x and y
        // x ^ y = xorSum
        // KEY: the rightmost set bit of x is x & -x
        // (if we ignore the positive / negative mark). x can be split into three part (a)1(b), where all bits in b are 0,
        // -x in binary is ~x + 1, ~x = (~a)0(~b), all bits in (~b) should be 1.
        // -x = ~x + 1 = (~a)1(b)
        // x & -x = (a)1(b) & (~a)1(b) = 1(b) = 100...0
        // get the rightmost (lowest bit) of `xorSum`
        int rightmostBit = xorSum & -xorSum;
        // one of the number x, y at `rightmostBit` is 1, another is 0
        // Divide the all numbers in `nums` into 2 group based on this rightmost bit
        int x1 = 0;
        int x2 = 0;
        for (int num : nums) {
            if ((num & rightmostBit) != 0) {
                x1 ^= num;
            } else {
                x2 ^= num;
            }
        }
        for (int i = 0; i < n; i++) {
            if ((i & rightmostBit) != 0) {
                x1 ^= i;
            } else {
                x2 ^= i;
            }
        }

        return new int[] {x1, x2};
    }
}
