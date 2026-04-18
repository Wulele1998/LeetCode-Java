package LC777;

public class Solution {
    public boolean canTransform(String start, String end) {
        // time: O(N)

        // step 1: check the length are equal
        // step 2: check the number of 'X' character are equal
        // step 3: check every 'L' and 'R' are in the relatively equal index

        // step 1
        int m = start.length();
        int n = end.length();
        if (m != n) {
            return false;
        }

        // step 2
        int countX = 0;
        for (int i = 0; i < n; i++) {
            if (start.charAt(i) == 'X') {
                countX++;
            }
            if (end.charAt(i) == 'X') {
                countX--;
            }
        }
        if (countX != 0) {
            return false;
        }

        int i = 0; // index of string `start`
        int j = 0; // index of string `end`
        while (i < n && j < n) {
            // skip all 'X', and find 'L' or 'R'
            while (i < n && start.charAt(i) == 'X') {
                i++;
            }
            while (j < n && end.charAt(j) == 'X') {
                j++;
            }

            if (i == n && j == m) {
                return true; // if both i and j reach the end, true
            }
            if (i == n || j == n) {
                return false; // if one of them reach the end but another doesn't, false
            }
            // both i and j are in the valid index range [0, n - 1]
            if (start.charAt(i) != end.charAt(j)) {
                return false;
            }
            if (start.charAt(i) == 'L' && i < j) {
                // since we can only move 'L' to its left, so the 'L' at `string` should at the right of the `end` string
                return false;
            }
            if (start.charAt(i) == 'R' && i > j) {
                return false;
            }
            i++;
            j++;
        }

        return true;
    }
}
