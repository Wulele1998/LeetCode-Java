package LC590;

import library.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 590. N-ary Tree Postorder Traversal
 */

public class Solution {
    List<Integer> res;
    public List<Integer> postorder(Node root) {
        // N: the number of nodes
        // time: O(N)
        // space: O(N), recursive stack
        res = new ArrayList<>();
        postOrderHelper(root);

        return res;
    }

    private void postOrderHelper(Node root) {
        if (root == null) {
            return;
        }

        for (Node child : root.children) {
            postOrderHelper(child);
        }
        res.add(root.val);
    }
}
