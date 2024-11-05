package LC657;

public class Solution {
    public boolean judgeCircle(String moves) {
        // N: the length of `moves`
        // time: O(N)
        // space: O(1)
        int up = 0, down = 0, left = 0, right = 0;
        
        for (char move : moves.toCharArray()) {
            switch (move) {
                case 'U':
                    up++;
                    break;
                case 'D':
                    down++;
                    break;
                case 'L':
                    left++; 
                    break;
                case 'R':
                    right++;
                    break;
                default:
                    break;
            }
        }

        return up == down && right == left;
    }
}
