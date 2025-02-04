package LC1701;

/**
 * LC 1701. Average Waiting Time
 */
public class Solution {
    public double averageWaitingTime(int[][] customers) {
        // N: the number of customers
        // time: O(N)
        // space: O(1)
        int n = customers.length;
        long sum = 0;
        int time = 0;
        for (int i = 0; i < n; i++) {
            time = Math.max(time, customers[i][0]);
            time += customers[i][1];
            sum += time - customers[i][0];
        }
        return (double) sum / n;    
    }
}
