package LC100;

import library.TreeNode;

/**
 * LC 100. Same Tree
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q)  {
        // recursion
        // N: the number of nodes in the tree
        // time: O(N)
        // space: O(N)
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
