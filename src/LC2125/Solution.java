package LC2125;

public class Solution {
    public int numberOfBeams(String[] bank) {
        // M: the length of `bank`
        // N: the length of each bank string
        // time: O(M * N)
        // space: O(1)
        int m = bank.length;
        int res = 0;
        
        int i = 0;
        while (i < m) {
            while (i < m && ones(bank[i]) == 0) {
                i++;
            }
            int next = i + 1;
            while (next < m && ones(bank[next]) == 0) {
                next++;
            }
            
            if (next < m) {
                res += ones(bank[i]) * ones(bank[next]);
            }

            i = next;
        }

        return res;
    }

    private int ones(String s) {
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '1')
                count++;
        }

        return count;
    }
}
