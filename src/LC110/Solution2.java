package LC110;

import library.TreeNode;

class TreeInfo {
    public int height;
    public boolean isBalanced;

    public TreeInfo(int height, boolean isBalanced) {
        this.height = height;
        this.isBalanced = isBalanced;
    }
}
public class Solution2 {
    public boolean isBalanced(TreeNode root) {
        // bottom-up recursion
        // N: the number of nodes in the tree
        // time: O(N)
        // space: O(N)
        return isBalancedTreeHelper(root).isBalanced;
    }

    private TreeInfo isBalancedTreeHelper(TreeNode root) {
        if (root == null) {
            return new TreeInfo(0, true);
        }

        TreeInfo left = isBalancedTreeHelper(root.left);
        if (!left.isBalanced) {
            return new TreeInfo(left.height, false);
        }
        TreeInfo right = isBalancedTreeHelper(root.right);
        if (!right.isBalanced) {
            return new TreeInfo(right.height, false);
        }

        if (Math.abs(left.height - right.height) > 1) {
            return new TreeInfo(Math.max(left.height, right.height) + 1, false);
        }

        return new TreeInfo(Math.max(left.height, right.height) + 1, true);
    }
}
