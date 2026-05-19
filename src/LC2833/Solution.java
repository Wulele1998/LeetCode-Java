package LC2833;

public class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int l = 0;
        int r = 0;
        int n = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'L':
                    l++;
                    break;
                case 'R':
                    r++;
                    break;
                case '_':
                    n++;
                    break;
            }
        }

        return Math.abs(l - r) + n;
    }
}
