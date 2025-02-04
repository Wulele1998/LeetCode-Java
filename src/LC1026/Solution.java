package LC1026;

import library.TreeNode;

public class Solution {
    // time: O(N)
    // space: O(log N)
    int res = 0;
    public int maxAncestorDiff(TreeNode root) {
        findMaxDiff(root, root.val, root.val);
        return res;
    }

    private void findMaxDiff(TreeNode root, int curMax, int curMin) {
        if (root == null) 
            return;
        int diff = Math.max(Math.abs(curMax - root.val), Math.abs(curMin - root.val));
        res = Math.max(res, diff);
        // update the max and min value
        curMax = Math.max(curMax, root.val);
        curMin = Math.min(curMin, root.val);
        findMaxDiff(root.left, curMax, curMin);
        findMaxDiff(root.right, curMax, curMin);
    }
}
