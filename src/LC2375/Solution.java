package LC2375;

/**
 * LC 2375. Construct Smallest Number From DI String
 */
public class Solution {
    public String smallestNumber(String pattern) {
        // N: the length of `pattern`
        // time: O(N!)
        // space: O(N), recursive stack
        int n = pattern.length();
        int[] res = new int[n + 1];
        boolean[] used = new boolean[10]; // number  1 - 9

        backtrack(res, pattern, used, 0);

        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            sb.append(num);
        }

        return sb.toString();
    }

    private boolean backtrack(int[] res, String pattern, boolean[] used, int curIndex) {
        if (curIndex == res.length) {
            return true;
        }

        for (int num = 1; num <= 9; num++) {
            // lexicographically smaller, start from 1 to 9
            if (curIndex == 0) {
                // first letter, no pattern limit
                if (!used[num]) {
                    used[num] = true;
                    res[curIndex] = num;
                    if (backtrack(res, pattern, used, curIndex + 1)) {
                        return true;
                    } else {
                        used[num] = false; // roll back for next number
                    }
                }
            } else {
                int prevNum = res[curIndex - 1];
                if (pattern.charAt(curIndex - 1) == 'I' && num > prevNum && !used[num]) {
                    used[num] = true;
                    res[curIndex] = num;
                    if (backtrack(res, pattern, used, curIndex + 1)) {
                        return true;
                    } else {
                        used[num] = false; // roll back for next number
                    }
                } else if (pattern.charAt(curIndex - 1) == 'D' && num < prevNum && !used[num]) {
                    used[num] = true;
                    res[curIndex] = num;
                    if (backtrack(res, pattern, used, curIndex + 1)) {
                        return true;
                    } else {
                        used[num] = false;
                    }
                }
            }
        }

        return false;
    }
}
