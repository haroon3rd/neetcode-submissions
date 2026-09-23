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
    int maxPath = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameterBST(root);
        return maxPath;
        
    }

    int diameterBST(TreeNode root){
        if(root==null)
            return -1;
        int leftPath = diameterBST(root.left) +1;
        int rightPath = diameterBST(root.right) +1;

        int lengthAt = leftPath + rightPath;
        maxPath = Math.max(maxPath,lengthAt);
        return Math.max(leftPath, rightPath);

    }
}
