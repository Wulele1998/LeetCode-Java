package LC22;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();

        backtrackHelper(n, 0, 0, new StringBuilder());

        return res;
    }

    private void backtrackHelper(int n, int left, int right, StringBuilder sb) {
        if (sb.length() == n * 2) {
            res.add(new String(sb));
            return;
        }

        if (left < n) {
            sb.append('(');
            backtrackHelper(n, left + 1, right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(')');
            backtrackHelper(n, left, right + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
