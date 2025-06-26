package LC124;

import library.TreeNode;

/**
 * LC 124. Binary Tree Maximum Path Sum
 */
public class Solution {
    private int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // N: the number of node in the tree
        // time: O(N)
        // space: O(N), recursive stack
        maxPathSumSub(root);
        return res;
    }

    private int maxPathSumSub(TreeNode root){
        if (root == null) {
            return 0;
        }

        int leftMaxPathSum = Math.max(0, maxPathSumSub(root.left));
        int rightMaxPathSum = Math.max(0, maxPathSumSub(root.right));
        // update the path sum cross this subtree
        res = Math.max(res, root.val + leftMaxPathSum + rightMaxPathSum);

        // update the path sum as a part of the path
        return Math.max(leftMaxPathSum, rightMaxPathSum) + root.val;
    }
}
