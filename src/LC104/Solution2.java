package LC104;

import library.TreeNode;
import java.util.Queue;
import java.util.LinkedList;

class Pair {
    TreeNode node;
    int depth;

    public Pair(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}

public class Solution2 {


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 1));

        int maxDepth = 0;
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            maxDepth = Math.max(maxDepth, cur.depth);
            if (cur.node.left != null) {
                queue.offer(new Pair(cur.node.left, cur.depth + 1));
            }
            if (cur.node.right != null) {
                queue.offer(new Pair(cur.node.right, cur.depth + 1));
            }
        }

        return maxDepth;
    }
}
