package OA;

import library.TreeNode;

import java.util.List;
import java.util.ArrayList;

public class BinaryTreePaths {
    // N: the number of nodes in the tree
    // L: the number of leaves in the tree
    // H: the height of the tree
    // time: O(N + L * H)
    // space: O(L * H)
    List<List<Integer>> paths;
    public List<List<Integer>> findAllPaths(TreeNode root) {
        paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }

        DFS(root, new ArrayList<>());

        return paths;
    }

    private void DFS(TreeNode root, List<Integer> path) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            paths.add(new ArrayList<>(path));
        } else {
            if (root.left != null) {
                DFS(root.left, path);
            }
            if (root.right != null) {
                DFS(root.right, path);
            }
        }
        path.remove(path.size() - 1); // backtrack
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        BinaryTreePaths test = new BinaryTreePaths();
        List<List<Integer>> res = test.findAllPaths(root);
        System.out.println(res);
    }
}
