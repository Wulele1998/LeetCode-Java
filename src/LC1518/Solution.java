package LC1518;

/**
 * LC 1518. Water Bottles
 */
public class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        // time: O(N)
        // space: O(1)
        int res = 0;
        res += numBottles;

        while (numBottles / numExchange > 0) {
            int left = numBottles % numExchange;
            numBottles = numBottles / numExchange;
            res += numBottles;
            numBottles += left;
        }   

        return res;
    }
}
