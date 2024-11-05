package LC623;

import java.util.LinkedList;
import java.util.Queue;
import library.TreeNode;

/**
 * LC 623. Add One Row to Tree
 */
public class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // BFS
        // N: the number of nodes in the tree
        // time: O(N)
        // space: O(N)
        if (root == null)
            return null;
        if (depth == 1) {
            // add the node above the root
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        for (int d = 1; d < depth - 1; d++) {
            // BFS search by each layer of the tree
            int n = queue.size();
            
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }

        for (TreeNode node : queue) {
            TreeNode leftSubtree = node.left;
            TreeNode rightSubtree = node.right;
            if (leftSubtree != null) {
                TreeNode addNode = new TreeNode(val);
                node.left = addNode;
                addNode.left = leftSubtree;
            } else {
                node.left = new TreeNode(val);
            }

            if (rightSubtree != null) {
                TreeNode addNode = new TreeNode(val);
                node.right = addNode;
                addNode.right = rightSubtree;
            } else {
                node.right = new TreeNode(val);
            }
        }

        return root;
    }
}
