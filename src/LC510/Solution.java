package LC510;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}

public class Solution {
    public Node inorderSuccessor(Node node) {
        Node successor;
        if (node.right != null) {
            successor = node.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            return successor;
        } else if (node.parent != null) {
            successor = node.parent;
            if (successor.left == node) {
                return successor;
            }
            while (successor.parent != null && successor.parent.right == successor) {
                successor = successor.parent;
            }
            return successor.parent;
        }

        return null;
    }
}