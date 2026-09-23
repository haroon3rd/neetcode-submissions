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
    List<List<Integer>> llist = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrder(root, 0);
        return llist;
    }
    void levelOrder(TreeNode root, int level){
        if(root==null)
            return;
        if(llist.size() == level)
            llist.add(new ArrayList<>());
        llist.get(level).add(root.val); //add the the root val to correct level
        levelOrder(root.left, level+1);
        levelOrder(root.right, level+1);
    }
}
