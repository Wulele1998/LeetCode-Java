package LC133;

import java.util.*;

public class Solution {
    // V: the number of nodes
    // E: the number of edges
    // time: O(V + E)
    // space: O(V)
    private Map<Node, Node> nodeMap;
    public Node cloneGraph(Node node) {
        // edge cases
        if (node == null) {
            return null;
        }

        nodeMap = new HashMap<>();

        bfs(node);

        return nodeMap.get(node);
    }

    private void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        Node nodeCopy = new Node(node.val);
        nodeMap.put(node, nodeCopy);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node adj : cur.neighbors) {
                if (!nodeMap.containsKey(adj)) {
                    Node adjCopy = new Node(adj.val);
                    nodeMap.put(adj, adjCopy);
                }
                nodeMap.get(cur).neighbors.add(nodeMap.get(adj));
            }
        }
    }
}
