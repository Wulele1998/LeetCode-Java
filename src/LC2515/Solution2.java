package LC2515;

public class Solution2 {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int res = Integer.MAX_VALUE;
        int l = startIndex;
        int r = startIndex;
        int move = 0;
        while (move <= n / 2) {
            if (words[l].equals(target) || words[r].equals(target)) {
                return move;
            }
            l = (l - 1 + n) % n;
            r = (r + 1) % n;
            move++;
        }

        return -1;
    }
}
