package LC144;

import library.TreeNode;

import java.util.*;

/**
 * LC 144. Binary Tree Preorder Traversal
 */
public class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        // edge case
        if (root == null) {
            return res;
        }
        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(root.val); // root first

            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }

        return res;
    }
}
