package LC404;

import library.TreeNode;

/**
 * LC 404. Sum of Left Leaves
 */
public class Solution {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        // N: the number of nodes 
        // time: O(N)
        // space: O(N)
        leftLeaveFinder(root, false);
        return sum;
    }

    private void leftLeaveFinder(TreeNode root, boolean isLeft) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && isLeft) {
            // the node is a left leaf
            sum += root.val;
        }
        leftLeaveFinder(root.left, true);
        leftLeaveFinder(root.right, false);
    }
}
