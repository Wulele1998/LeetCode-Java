package LC606;

import library.TreeNode;

public class Solution {
    StringBuilder res = new StringBuilder();

    public String tree2str(TreeNode root) {
        // N: the node number of the tree
        // time: O(N)
        // space: O(1)
        preorder(root);

        return res.toString();
    }

    private void preorder(TreeNode node) {
        if (node == null) {
            return;
        }
        res.append(node.val);
        if (node.left == null && node.right == null) {
            return;
        }
        res.append('(');
        preorder(node.left);
        res.append(')');

        if (node.right != null) {
            res.append('(');
            preorder(node.right);
            res.append(')');
        }
    }
}
