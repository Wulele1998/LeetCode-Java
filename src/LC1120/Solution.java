package LC1120;

import library.TreeNode;

public class Solution {
    class NodePro {
        int nodeCount;
        int sum;
        double maxAvg;

        NodePro(int nodeCount, int sum, double maxAvg) {
            this.nodeCount = nodeCount;
            this.sum = sum;
            this.maxAvg = maxAvg;
        }
    }

    private NodePro maxAverage(TreeNode node) {
        if (node == null) {
            return new NodePro(0, 0, 0);
        }
        NodePro left = maxAverage(node.left);
        NodePro right = maxAverage(node.right);

        int nodeCount = left.nodeCount + right.nodeCount + 1;
        int sum = left.sum + right.sum + node.val;
        double avg = sum * 1.0 / nodeCount;
        double maxAvg = Math.max(Math.max(left.maxAvg, right.maxAvg), avg);
        return new NodePro(nodeCount, sum, maxAvg);
    }

    public double maximumAverageSubtree(TreeNode root) {
        // N: the number of node in the tree
        // time: O(N)
        // space: O(N + log N), recursion stack space and extra space of NodePro
        return maxAverage(root).maxAvg;
    }
}
