package LC144;

import library.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 144. Binary Tree Preorder Traversal
 */
public class Solution {
    // N: the number of nodes in the tree
    // time: O(N)
    // space: O(N)
    List<Integer> res;
    public List<Integer> preorderTraversal(TreeNode root) {
        // use recursion
        res = new ArrayList<>();

        preorderHelper(root);

        return res;
    }

    private void preorderHelper(TreeNode root) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        preorderHelper(root.left);
        preorderHelper(root.right);
    }
}
