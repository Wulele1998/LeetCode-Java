package OA;

import library.TreeNode;

/**
 * Create a new BST containing only nodes within [min, max].
 */
public class FilterBST {
    public TreeNode filterBST(TreeNode root, int min, int max) {
        if (root == null)
            return null;

        if (root.val < min) {
            return filterBST(root.right, min, max);
        } else if (root.val > max) {
            return filterBST(root.left, min, max);
        } else {
            TreeNode newRoot = new TreeNode(root.val);
            newRoot.left = filterBST(root.left, min, root.val - 1);
            newRoot.right = filterBST(root.right, root.val + 1, max);
            return newRoot;
        }
    }
}
