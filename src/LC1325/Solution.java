package LC1325;

import library.TreeNode;
/**
 * LC 1325. Delete Leaves With a Given Value
 */
public class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        // N: the number of nodes in the tree
        // time: O(N)
        // space: O(N)
        if (root == null) {
            return null;
        }

        // look through the left and right subtree
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        // remove the leave node
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }

        return root;
    }
}
