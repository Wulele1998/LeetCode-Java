package LC145;

import library.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution2 {
    // iteration
    public List<Integer> postorderTraversal(TreeNode root) {
        // N: the number of nodes in the tree
        // time: O(N)
        // space: O(N)
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        // left, right, root => (root, right, left) reverse
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(root.val);
            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
        }

        Collections.reverse(res);
        return res;
    }
}
