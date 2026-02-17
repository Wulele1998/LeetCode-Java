package LC145;

import library.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 145. Binary Tree Postorder Traversal
 */
public class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        // N: the number of tree nodes
        // time: O(N)
        // space: O(N), stack space
        postOrderHelper(root);

        return res;
    }

    private void postOrderHelper(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrderHelper(root.left);
        postOrderHelper(root.right);

        res.add(root.val);
    }
}
