package LC762;

import java.util.HashSet;
import java.util.Set;

/**
 * Feb 21, 2026
 * LC 762. Prime Number of Set Bits in Binary Representation
 */
public class Solution {
    Set<Integer> primeSet;

    public int countPrimeSetBits(int left, int right) {
        createPrimeSet();
        int res = 0;

        for (int i = left; i <= right; i++) {
            if (primeSet.contains(setBitCount(i))) {
                res++;
            }
        }

        return res;
    }

    private void createPrimeSet() {
        primeSet = new HashSet<>();
        
        primeSet.add(2);
        primeSet.add(3);
        primeSet.add(5);
        primeSet.add(7);
        primeSet.add(11);
        primeSet.add(13);
        primeSet.add(17);
        primeSet.add(19);
    }

    private int setBitCount(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n >>= 1;
        }

        return count;
    }
}


