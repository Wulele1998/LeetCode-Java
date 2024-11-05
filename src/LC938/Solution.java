package LC938;

import library.TreeNode;

public class Solution {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        BSTHelper(root, low, high);

        return sum;
    }

    private void BSTHelper(TreeNode root, int low, int high) {
        if (root == null)
            return;
        if (root.val >= low && root.val <= high) {
            sum += root.val;
            BSTHelper(root.left, low, high);
            BSTHelper(root.right, low, high);
        } else if (root.val < low) {
            BSTHelper(root.right, low, high);
        } else {
            BSTHelper(root.left, low, high);
        }
    }
}
