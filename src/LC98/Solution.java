package LC98;

import library.TreeNode;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return recursion(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean recursion(TreeNode root, long low, long high) {
        if (root == null) {
            return true;
        }
        if (root.val <= low || root.val >= high) {
            return false;
        }

        return recursion(root.left, low, root.val) && recursion(root.right, root.val, high);
    }
}
