package LC1120;

import library.TreeNode;
public class Solution2 {
    double res = 0.0;
    public double maximumAverageSubtree(TreeNode root) {
        // N: the number of node in the tree
        // time: O(N)
        // space: O(log N), recursion stack space
        helper(root);

        return res;
    }

    private double[] helper(TreeNode node) {
        if (node == null) {
            return new double[] {0.0, 0.0};
        }
        double count = 1.0;
        double sum = node.val;
        double[] dataLeft = helper(node.left);
        count += dataLeft[0];
        sum += dataLeft[1];
        double[] dataRight = helper(node.right);
        count += dataRight[0];
        sum += dataRight[1];

        res = Math.max(res, sum / count);
        return new double[] {count, sum};
    }
}
