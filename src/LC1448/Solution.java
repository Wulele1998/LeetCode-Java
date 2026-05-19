package LC1448;

import library.TreeNode;

public class Solution {
    private int res;
    public int goodNodes(TreeNode root) {
        res = 0;

        dfs(root, Integer.MIN_VALUE);

        return res;
    }

    private void dfs(TreeNode root, int maxVal) {
        if (root == null) {
            return;
        }
        if (root.val >= maxVal) {
            res++;
            maxVal = root.val;
        }
        dfs(root.left, maxVal);
        dfs(root.right, maxVal);
    }
}
