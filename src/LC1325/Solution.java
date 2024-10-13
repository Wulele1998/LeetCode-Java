package LC1325;

import library.TreeNode;
/**
 * LC 1325. Delete Leaves With a Given Value
 */
public class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        // remove the leave node
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        return root;
    }
}
