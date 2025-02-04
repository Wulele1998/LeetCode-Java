package LC1611;

public class Solution {
    public int minimumOneBitOperations(int n) {
        // 001 -> 000
        // 010 -> 011 -> 001 -> 000
        // 011 -> 001 -> 000
        // 100 -> 101 -> 
        // 101 -> 111 -> 110 -> 010 -> 011 -> 001 -> 000 
        // 110 -> 010 -> 011 -> 001 -> 000
        // 111 -> 110 -> 010 -> 011 -> 001 -> 000
        // 110 -> 010 -> 11 -> 01 -> 00

        
        // 0 -> n = X
        // 0 -> n' = g(n')
        // 0 -> 2^k = f(k)
        // 2^k -> n = g(n')

        // n: `n`
        // time: O(log n * log n)
        // space: O(log n), recursion call stack
        // base case
        if (n == 0) {
            return 0;
        }

        int base = 1;
        // 2 ** k
        // 2 ** 0 = 1
        int k = 0;

        while ((base << 1) <= n) {
            base <<= 1;
            k++;
        }
        
        // f(x) = 2 * f(x - 1) + 1
        // f(0) = 0
        // f(1) = 1
        // f(2) = 3
        // f(3) = 7
        // f(x + 1) = 2 * f(x) + 1
        // f(x) = 2 * (2 * f(x - 2) + 1) + 1
        // f(x) = 2 * (2 * (2 * .... (2 * f(0) + 1) + 1 ...) + 1) + 1
        // f(x) = 2 ** x + (1 + 2 + 4 + 8 + .. + 2 ** (x - 1))
        // f(x) = 2 ** x + 1 * (1 - 2 ** x) / (1 - 2) = 2 ** (x + 1) - 1
        // 
        // f(k) = 2 ** (k + 1) - 1

        // n = 10110
        // base = 10000
        // n XOR base = 00110
        return (1 << (k + 1)) - 1 - minimumOneBitOperations(n ^ base);
    }
}
