package LC2515;

/**
 * LC 2515. Shortest Distance to Target String in a Circular Array
 * April 15, 2026
 */
public class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int distance = Math.abs(i - startIndex);
                distance = Math.min(distance, n - distance);
                res = Math.min(res, distance);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
