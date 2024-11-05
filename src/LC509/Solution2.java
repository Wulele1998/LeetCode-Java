package LC509;

public class Solution2 {
    public int fib(int n) {
        // N: the number `n`
        // time: O(N)
        // space: O(1)
        if (n == 0 || n == 1)
            return n;
        int num1 = 0;
        int num2 = 1;
    
        for (int i = 2; i <= n; i++) {
            int num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
        }

        return num2;
    }
}
