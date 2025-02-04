package LC2582;

/**
 * LC 2582. Pass the Pillow
 */
public class Solution {
    public int passThePillow(int n, int time) {
        // time: O(1)
        // space: O(1)
        int k = time / (n - 1);
        
        return (k % 2 == 0) ? (time % (n - 1)) : n - (time % (n - 1));
    }
}
