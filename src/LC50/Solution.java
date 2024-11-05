package LC50;

public class Solution {
    // recursion
    // time: O(log N)
    // space: O(log N), recursion stack space
    public double myPow(double x, int n) {
        return binaryPow(x, (long) n);
    }

    private double binaryPow(double x, long n) {
        if (n == 0)
            return 1;
        if (n < 0) 
            // need to take negative number in to consider
            // int range [-2,147,483,648, 2,147,483,647]
            // [- 2 ^ 31, 2 ^ 31 - 1]
            // need to use long if you want to flip negative number to positive 
            return 1.0 / binaryPow(x, -n);
        if ((n & 1) != 0) 
            return x * binaryPow(x * x, (n - 1) >> 1);
        else
            return binaryPow(x * x, n >> 1);
    }
}
