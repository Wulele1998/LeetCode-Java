package LC94;

import library.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // recursion
    // N: the number of tree node
    // time: O(N)
    // space: O(log N), recursion stack which is the height of the tree
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);

        return res;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inorder(node.left);
        }
        res.add(node.val);
        if (node.right != null) {
            inorder(node.right);
        }
    }
}
