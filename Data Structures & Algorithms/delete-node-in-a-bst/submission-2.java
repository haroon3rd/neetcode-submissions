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

    int findMin(TreeNode root) {
        if (root.left == null)
            return root.val;
        else
            return findMin(root.left);
    }

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null)
            return null;

        if (key < root.val)
            root.left = deleteNode(root.left, key);

        else if (key > root.val)
            root.right = deleteNode(root.right, key);

        else { // root.val == key

            // No left child
            if (root.left == null)
                return root.right;

            // No right child
            if (root.right == null)
                return root.left;

            // Two children
            root.val = findMin(root.right);
            root.right = deleteNode(root.right, root.val);
        }

        return root;
    }
}
