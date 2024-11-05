package LC1041;

public class Solution {
    public boolean isRobotBounded(String instructions) {
        // N: the length of `instructions`
        // time: O(N)
        // space: O(1)
        int x = 0;
        int y = 0;
        int[][] DIRECTS = new int[][] {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        int cur = 0;

        for (char c : instructions.toCharArray()) {
            switch (c) {
                case 'G':
                    x += DIRECTS[cur][0];
                    y += DIRECTS[cur][1];            
                    break;
                case 'L':
                    cur++;
                    if (cur > 3)
                        cur -= 4;
                    break;
                case 'R':
                    cur--;
                    if (cur < 0)
                        cur += 4;
                default:
                    break;
            }
        }
        return (x == 0 && y == 0) || cur != 0;
    }
}
