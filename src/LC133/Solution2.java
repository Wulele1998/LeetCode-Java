package LC133;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    // V: the number of nodes
    // E: the number of edges
    // time: O(V + E)
    private Map<Node, Node> nodeMap;

    public Node cloneGraph(Node node) {
        // edge cases
        if (node == null) {
            return null;
        }

        nodeMap = new HashMap<>();
        return dfs(node);
    }

    private Node dfs(Node node) {
        if (nodeMap.containsKey(node)) {
            return nodeMap.get(node);
        }

        Node nodeCopy = new Node(node.val);
        nodeMap.put(node, nodeCopy);

        for (Node adj : node.neighbors) {
            nodeCopy.neighbors.add(dfs(adj));
        }

        return nodeCopy;
    }
}
