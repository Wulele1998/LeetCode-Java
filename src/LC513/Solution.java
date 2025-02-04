package LC513;

import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import library.TreeNode;

/**
 * LC 513. Find Bottom Left Tree Value
 */
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        /**
         * N: the number of nodes in the tree
         * time: O(N)
         * space: O(N)
         */
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> leaves = new ArrayList<>();
        while (!queue.isEmpty()) {
            int n = queue.size();
            leaves = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                leaves.add(cur.val);
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
        }

        return leaves.get(0);
    }
}
