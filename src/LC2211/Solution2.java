package LC2211;

/**
 * Dec 4, 2025
 * LC 2211. Count Collisions on a Road
 */
public class Solution2 {
    public int countCollisions(String directions) {
        int res = 0;
        int left = 0;
        int right = directions.length() - 1;

        while (left < directions.length() && directions.charAt(left) == 'L') {
            left++; // skip all continuous L from left
        }
        while (right >= left && directions.charAt(right) == 'R') {
            right--; // skip all continuous R from right
        }

        for (int i = left; i <= right; i++) {
            if (directions.charAt(i) != 'S') {
                res++;
            }
        }

        return res;
    }
}
