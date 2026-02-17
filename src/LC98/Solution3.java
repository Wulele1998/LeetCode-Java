package LC98;

import library.TreeNode;

/**
 * LC 98. Validate Binary Search Tree
 */
public class Solution3 {
    TreeNode prevNode; // prev node which owns the greatest value
    public boolean isValidBST(TreeNode root) {
        prevNode = null;
        return inOrderCheck(root);
    }

    private boolean inOrderCheck(TreeNode root) {
        if (root == null) {
            return true;
        }

        // check left subtree
        if (!inOrderCheck(root.left)) {
            return false;
        }
        if (prevNode != null && prevNode.val >= root.val) {
            return false;
        }
        prevNode = root; // update prevNode

        return inOrderCheck(root.right);
    }
}
