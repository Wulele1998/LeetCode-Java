package LC654;

import library.TreeNode;

public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null; // edge case
        }

        return buildMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildMaximumBinaryTree(int[] nums, int l, int r) {
        // range [l, r]
        if (l > r) {
            return null;
        }
        int maxIndex = getMaxIndex(nums, l, r);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = buildMaximumBinaryTree(nums, l, maxIndex - 1);
        root.right = buildMaximumBinaryTree(nums, maxIndex + 1, r);

        return root;
    }

    private int getMaxIndex(int[] nums, int l, int r) {
        int res = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] > nums[res]) {
                res = i;
            }
        }

        return res;
    }
}
