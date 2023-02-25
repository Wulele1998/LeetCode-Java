package LC110;

import library.TreeNode;
public class Solution {
    public boolean isBalanced(TreeNode root) {
        // top-down recursion
        // N: the number of nodes in the tree
        // time: O(N * log N)
        // space: O(N) => recursive stack
        if (root == null) {
            return true;
        }
        if (Math.abs(height(root.left) - height(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
