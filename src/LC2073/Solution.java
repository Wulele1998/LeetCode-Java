package LC2073;

/**
 * LC 2073. Time Needed to Buy Tickets
 */
public class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        // N: the length of `tickets`
        // time: O(N)
        // space: O(N)
        int n = tickets.length;
    
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (i <= k) {
                res += Math.min(tickets[k], tickets[i]);
            } else {
                res += Math.min(tickets[k] - 1, tickets[i]);
            }
        }

        return res;
    }
}
