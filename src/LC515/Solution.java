package LC515;

import library.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LC 515. Find Largest Value in Each Tree Row
 */
public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        // BFS
        // N: the number of nodes in the tree
        // time: O(N)
        // space: O(N)
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        if (root == null)
            return res;

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                maxValue = Math.max(maxValue, node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }

            res.add(maxValue);
        }

        return res;
    }
}
