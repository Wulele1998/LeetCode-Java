package LC428;

import library.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) // edge case
            return "N#0";

        StringBuilder sb = new StringBuilder();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current == null) {
                sb.append("N#0").append(",");
            } else {
                sb.append(current.val).append("#");
                if (current.children == null) {
                    sb.append(0).append(",");
                } else {
                    sb.append(current.children.size()).append(",");
                    for (Node child : current.children) {
                        queue.offer(child);
                    }
                }
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        String[] values = data.split(",");
        if (values[0].equals("N#0")) {
            return null; // edge cases
        }

        int index = 0;
        String[] rootData = values[index++].split("#");
        Node root = new Node(Integer.parseInt(rootData[0]), new ArrayList<>());
        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> childrenSize = new LinkedList<>();
        queue.offer(root);
        childrenSize.offer(Integer.parseInt(rootData[1]));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int size = childrenSize.poll();

            for (int i = 0; i < size; i++) {
                String[] childData = values[index++].split("#");
                Node child = new Node(Integer.parseInt(childData[0]), new ArrayList<>());
                current.children.add(child);
                queue.offer(child);
                childrenSize.offer(Integer.parseInt(childData[1]));
            }
        }

        return root;
    }
}