/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int[] inorder,
                           int left, int right) {

        if (left > right) {
            return null;
        }

        // First element in preorder is the root
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Find root in inorder using a loop
        int mid = left;

        while (inorder[mid] != rootVal) {
            mid++;
        }

        // Build left and right subtrees
        root.left = helper(preorder, inorder, left, mid - 1);
        root.right = helper(preorder, inorder, mid + 1, right);

        return root;
    }
}
