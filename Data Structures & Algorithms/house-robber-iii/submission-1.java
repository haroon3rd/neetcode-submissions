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
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    // returns 2 numbers. one considering root as looted 0'th index
    // and another root not looted 1'th index
    int[] dfs(TreeNode root){
        if(root==null)
            return new int[2]; // return [0,0]
        
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int [] result = new int[2];
        // OPTION 1. we can rob root.
        result[0] = root.val + left[1] + right[1];

        // OPTION 2. we dont rob root.
        result[1] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        
        return result;
    }
}