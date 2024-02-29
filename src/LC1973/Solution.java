package LC1973;

import library.*;

public class Solution {
    /**
     * LC 1973. Count Nodes Equal to Sum of Descendants
     */
    int count = 0;
    public int equalToDescendants(TreeNode root) {
        // time: O(N)
        // space: O(N)
        count = 0;
        descentdantSum(root);

        return count;
    }

    private long descentdantSum(TreeNode root) {
        if (root == null)
            return 0;

        long leftSum = descentdantSum(root.left);
        long rightSum = descentdantSum(root.right);
        
        if (root.val == leftSum + rightSum)
            count++;
        
        return leftSum + rightSum + root.val;
    }
}