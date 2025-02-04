package LC226;

import library.TreeNode;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        // N: the number of node in the tree
        // time: O(N)
        // space: O(log N), recursion stack space
        if (root == null) {
            return null;
        }
        // switch the left and right node
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
