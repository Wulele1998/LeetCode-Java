package LC543;

import library.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    List<Integer> res;

    public int diameterOfBinaryTree(TreeNode root) {
        res = new ArrayList<>();

        DFS(root);

        return res.size() - 1;
    }

    private List<Integer> DFS(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> leftPath = DFS(root.left);
        List<Integer> rightPath = DFS(root.right);

        if (res.size() < leftPath.size() + rightPath.size() + 1) {
            res.clear();
            res.addAll(leftPath);
            res.add(root.val);
            res.addAll(rightPath);
        }

        List<Integer> curPath = new ArrayList<>();

        if (leftPath.size() >= rightPath.size()) {
            curPath.addAll(leftPath);
            curPath.add(root.val);
        } else {
            curPath.add(root.val);
            curPath.addAll(rightPath);
        }

        return curPath;
    }
}
