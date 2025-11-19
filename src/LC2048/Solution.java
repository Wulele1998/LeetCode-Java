package LC2048;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Oct 24, 2025
 * LC 2048. Next Greater Numerically Balanced Number
 */
public class Solution {
    List<Integer> balanceList;
    int MAX_NUM = 1224444;
    public int nextBeautifulNumber(int n) {
        balanceList = new ArrayList<>();
        generateBalancedNumbers(0, new int[10]);
        Collections.sort(balanceList);
        for (int num : balanceList) {
            if (num > n) {
                return num;
            }
        }

        return -1;
    }

    private void generateBalancedNumbers(int num, int[] count) {
        if (num > 0 && isBalanced(count)) {
            balanceList.add(num);
        }
        // 10 ^ 6 = 1_000_000;
        if (num >= MAX_NUM) {
            return;
        }
        for (int digit = 1; digit <= 7; digit++) {
            if (count[digit] < digit) {
                count[digit]++;
                generateBalancedNumbers(num * 10 + digit, count);
                count[digit]--; // backtrack
            }
        }
    }

    private boolean isBalanced(int[] count) {
        for (int i = 1; i <= 7; i++) {
            // 0 to 9
            if (count[i] != 0 && count[i] != i) {
                return false;
            }
        }

        return true;
    }
}
