package LC951;

import library.TreeNode;

/**
 * LC 951. Flip Equivalent Binary Trees
 */
public class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // recursion
        // N: the number of node in the tree
        // time: O(N)
        // space: O(N)

        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        if (root1.val != root2.val)
            return false;

        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
                || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
}
