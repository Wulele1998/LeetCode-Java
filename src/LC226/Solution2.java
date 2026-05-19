package LC226;

import library.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            TreeNode tmp = curNode.left;
            curNode.left = curNode.right;
            curNode.right = tmp;
            if (curNode.left != null) {
                queue.offer(curNode.left);
            }
            if (curNode.right != null) {
                queue.offer(curNode.right);
            }
        }

        return root;
    }
}
