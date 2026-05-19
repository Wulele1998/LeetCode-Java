package LC297;

import library.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "N";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null)
                sb.append("N,");
            else {
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodeValues = data.split(",");

        if (nodeValues[0].equals("N")) {
            return null;
        }

        int index = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodeValues[index++]));
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null)
                continue;
            TreeNode leftNode = nodeValues[index].equals("N") ? null : new TreeNode(Integer.parseInt(nodeValues[index]));
            index++;
            TreeNode rightNode = nodeValues[index].equals("N") ? null : new TreeNode(Integer.parseInt(nodeValues[index]));
            index++;
            queue.offer(leftNode);
            queue.offer(rightNode);
            cur.left = leftNode;
            cur.right = rightNode;
        }

        return root;
    }
}

