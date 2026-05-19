package LC285;

import library.TreeNode;

public class Solution {
    TreeNode successor;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        successor = null;
        inorder(root, p);

        return successor;
    }

    private void inorder(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        if (root.val > p.val) {
            successor = root;
            inorder(root.left, p);
        } else {
            inorder(root.right, p);
        }
    }
}
