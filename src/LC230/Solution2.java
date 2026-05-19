package LC230;

import library.TreeNode;

import java.util.Stack;

public class Solution2 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int res = 0;
        while (k > 0) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            res = root.val;
            root = root.right;
        }

        return res;
    }
}
