package LC860;

public class Solution {
    public boolean lemonadeChange(int[] bills) {
        // N: the length of `bills`
        // time: O(N)
        // space: O(1)
        int[] change = new int[2];
        
        for (int bill : bills) {
            if (bill == 5)
                change[0]++;
            else if (bill == 10) {
                if (change[0] < 1)
                    return false;
                change[0]--;
                change[1]++;
            } else {
                if (change[1] > 0) {
                    change[1]--;
                    if (change[0] == 0)
                        return false;
                    else
                        change[0]--;
                } else {
                    if (change[0] <= 2)
                        return false;
                    else
                        change[0] -= 3;
                }
            }
        }

        return true;
    }
}
