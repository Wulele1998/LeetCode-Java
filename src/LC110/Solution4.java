package LC110;

import library.TreeNode;

public class Solution4 {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return balancedTree(root) != -1;
    }

    private int balancedTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSub = balancedTree(root.left);
        int rightSub = balancedTree(root.right);
        if (leftSub == -1 || rightSub == -1 || Math.abs(leftSub - rightSub) > 1) {
            return -1;
        }

        return 1 + Math.max(leftSub, rightSub);
    }
}
