package LC1137;

public class Solution2 {
    public int tribonacci(int n) {
        if (n == 0) 
            return 0;
        if (n == 1 || n == 2)
            return 1;
            
        int num1 = 0, num2 = 1, num3 = 1;
        for (int i = 3; i <= n; i++) {
            int num4 = num1 + num2 + num3;
            num1 = num2;
            num2 = num3;
            num3 = num4;
        }

        return num3;
    }
}
