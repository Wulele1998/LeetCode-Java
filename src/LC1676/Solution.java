package LC1676;

import library.TreeNode;

/**
 * LC 1676. Lowest Common Ancestor of a Binary Tree IV
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        // N: the number of nodes in the tree
        // K: the length of `nodes`
        // time: O(N * K)
        // space: O(N)
        if (root == null) {
            return null;
        }

        for (TreeNode node : nodes) {
            if (node == root) {
                return root;
            }
        }

        TreeNode leftSub = lowestCommonAncestor(root.left, nodes);
        TreeNode rightSub = lowestCommonAncestor(root.right, nodes);

        if (leftSub == null && rightSub == null) {
            return null;
        } else if (leftSub == null) {
            return rightSub;
        } else if (rightSub == null) {
            return leftSub;
        } else {
            return root;
        }
    }
}
